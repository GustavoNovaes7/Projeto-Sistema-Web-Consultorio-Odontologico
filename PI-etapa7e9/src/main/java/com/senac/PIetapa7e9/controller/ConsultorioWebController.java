package com.senac.PIetapa7e9.controller;

import com.senac.PIetapa7e9.data.AtendimentoEntity;
import com.senac.PIetapa7e9.data.ConvenioEntity;
import com.senac.PIetapa7e9.data.DentistaEntity;
import com.senac.PIetapa7e9.data.EspecialidadeEntity;
import com.senac.PIetapa7e9.data.PacienteEntity;
import com.senac.PIetapa7e9.model.Usuario;
import com.senac.PIetapa7e9.service.ConsultorioService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConsultorioWebController {

    @Autowired
    ConsultorioService consultorioService;

    //Métodos para Pacientes
    @GetMapping("/index-cadastro")
    public String mostraTelaCadastro(@CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        PacienteEntity paciente = new PacienteEntity();
        List<ConvenioEntity> listaConvenios = consultorioService.listarConvenios();

        model.addAttribute("usuario", cookie);
        model.addAttribute("paciente", paciente);
        model.addAttribute("listarConvenios", listaConvenios);
        return "index-cadastro";
    }

    @PostMapping("/index-cadastro")
    public String salvarPaciente(@Valid @ModelAttribute("paciente") PacienteEntity paciente) {
        if (paciente.getId() == null) {
            consultorioService.criarPaciente(paciente);
        }
        return "redirect:/index-inicial";
    }

    @GetMapping("/index-atualizar/{pacienteUsuario}")
    public String mostraTelaAtualizar(@PathVariable(value = "pacienteUsuario") String pacienteUsuario, @CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        PacienteEntity paciente = consultorioService.getPacienteUsuario(pacienteUsuario);
        if (paciente == null) {
            return "redirect:/index-nao-esta-conectado";
        }
        ConvenioEntity convenioEscolhido = new ConvenioEntity();
        if (paciente.getConvenio() != null) {
            convenioEscolhido = consultorioService.getConvenioId(paciente.getConvenio().getId());
        } else {
            convenioEscolhido = null;
        }

        List<ConvenioEntity> listaConveniosSemEscolhido = consultorioService.listarConveniosSemEscolhido(paciente.getId());

        model.addAttribute("usuario", cookie);
        model.addAttribute("listarConveniosSemEscolhido", listaConveniosSemEscolhido);
        model.addAttribute("convenioEscolhido", convenioEscolhido);
        model.addAttribute("paciente", paciente);
        return "index-atualizar";
    }

    @PostMapping("/index-atualizar")
    public String atualizaPaciente(@Valid @ModelAttribute("filme") PacienteEntity paciente, Model model) {
        consultorioService.atualizarPaciente(paciente.getId(), paciente);
        return "redirect:/index-inicial";
    }

    //Métodos para Atendimentos/Consultas
    @GetMapping("/index-agendamento")
    public String mostraTelaAgendamento(@CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        AtendimentoEntity atendimento = new AtendimentoEntity();
        PacienteEntity paciente = consultorioService.getPacienteUsuario(cookie);
        if (paciente == null) {
            return "redirect:/index-nao-esta-conectado";
        }
        ConvenioEntity convenio = paciente.getConvenio();
        atendimento.setPaciente(paciente);
        atendimento.setConvenio(convenio);
        List<EspecialidadeEntity> listaEspecialidades = consultorioService.listarEspecialidades();
        List<DentistaEntity> listaDentistas = consultorioService.listarDentistasPorEspecialidade();

        model.addAttribute("listarEspecialidades", listaEspecialidades);
        model.addAttribute("listarDentistasPorEspecialidade", listaDentistas);
        model.addAttribute("usuario", cookie);
        model.addAttribute("atendimento", atendimento);
        return "index-agendamento";
    }

    @PostMapping("/index-agendamento")
    public String salvarAgendamento(@Valid @ModelAttribute("atendimento") AtendimentoEntity atendimento) {
        consultorioService.criarAtendimento(atendimento);
        return "redirect:/index-consultas";
    }

    @GetMapping("/index-consultas")
    public String mostraTelaConsultas(@CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        PacienteEntity paciente = consultorioService.getPacienteUsuario(cookie);
        if (paciente == null) {
            return "redirect:/index-nao-esta-conectado";
        }
        List<AtendimentoEntity> listaAtendimentos = consultorioService.listarAtendimentos(paciente.getId());

        model.addAttribute("listarAtendimentos", listaAtendimentos);
        model.addAttribute("usuario", cookie);
        return "index-consultas";
    }

    @GetMapping("/deletarConsulta/{atendimentoId}")
    public String deletarConsulta(@PathVariable(value = "atendimentoId") Integer id) {
        consultorioService.deletarAtendimento(id);
        return "redirect:/index-consultas";
    }

    //Métodos Gerais        
    @GetMapping("/index-inicial")
    public String mostraTelaInicial(@CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        model.addAttribute("usuario", cookie);
        return "index-inicial";
    }

    @GetMapping("/index-equipe")
    public String mostraTelaEquipe(@CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        model.addAttribute("usuario", cookie);
        return "index-equipe";
    }

    //Cookie e Login
    @GetMapping("index-login")
    public String mostraTelaLogin(@CookieValue(name = "cookieUsuario", defaultValue = "") String cookie, Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuarioNovo", usuario);
        model.addAttribute("usuario", cookie);
        return "index-login";
    }

    @PostMapping("/index-login")
    public String realizaLoginEsalvaCookie(@ModelAttribute Usuario usuario, HttpServletResponse response) {
        //Excluir cookie antigo
        Cookie cookieRemoverVelho = new Cookie("cookieUsuario", "");
        cookieRemoverVelho.setDomain("localhost");
        cookieRemoverVelho.setMaxAge(0);
        response.addCookie(cookieRemoverVelho);

        //Criar novo cookie
        Cookie cookieUsuarioNovo = new Cookie("cookieUsuario", usuario.getLogin());
        cookieUsuarioNovo.setDomain("localhost");
        cookieUsuarioNovo.setHttpOnly(true);
        cookieUsuarioNovo.setMaxAge(1800); //30 minutos
        response.addCookie(cookieUsuarioNovo);

        //Validando usuário
        List<PacienteEntity> listaPacientes = consultorioService.listarPacientes();
        for (PacienteEntity paciente : listaPacientes) {
            if (paciente.getLogin().equals(usuario.getLogin()) && paciente.getSenha().equals(usuario.getSenha())) {
                return "redirect:/index-inicial";
            }
        }
        return "redirect:/index-login-erro";
    }

    //Erros de Login e Não Logado
    @GetMapping("index-login-erro")
    public String mostraTelaLoginErro(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuarioNovo", usuario);
        return "index-login-erro";
    }

    @GetMapping("index-nao-esta-conectado")
    public String mostraTelaNaoConectado(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuarioNovo", usuario);
        return "index-nao-esta-conectado";
    }
}
