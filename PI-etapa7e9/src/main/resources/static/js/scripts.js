document.addEventListener("DOMContentLoaded", function () {

    /**Botão 'Atualizar Informações' - Tela Sua Conta*/
    var btnAtualizar = document.getElementById("btnAtualizar");
    var txtLogin = document.getElementById("txtLogin");
    var txtSenha = document.getElementById("txtSenha");

    function habilitarCampos() {
        var inputs = document.querySelectorAll("input, select");
        inputs.forEach(function (input) {
            input.removeAttribute("disabled");
        });
    }

    if (btnAtualizar) {
        btnAtualizar.addEventListener("click", function () {
            habilitarCampos();
        });
    }

    /**Possui ou não Convênio - Tela Agendamento*/
    var rbtnConvenioSim = document.getElementById("rbtnConvenioSim");
    var rbtnConvenioNao = document.getElementById("rbtnConvenioNao");
    var txtConvenio = document.getElementById("txtConvenio");

    if (rbtnConvenioSim) {
        rbtnConvenioSim.addEventListener("change", function () {
            if (rbtnConvenioSim.checked) {
                txtConvenio.removeAttribute("disabled");
            }
        });
    }

    if (rbtnConvenioNao) {
        rbtnConvenioNao.addEventListener("change", function () {
            if (rbtnConvenioNao.checked) {
                txtConvenio.setAttribute("disabled", true);
                txtConvenio.value = "";
            }
        });
    }

    /**Possui ou não Indicação através de Conhecido(a) - Tela Cadastro e Tela Sua Conta*/
    var slctIndicacao = document.getElementById("slctIndicacao");
    var txtNomeIndicacao = document.getElementById("txtNomeIndicacao");

    if (slctIndicacao) {
        slctIndicacao.addEventListener("change", function () {
            if (slctIndicacao.value != "Conhecido(a)") {
                txtNomeIndicacao.setAttribute("disabled", true);
                txtNomeIndicacao.value = "";
            } else {
                txtNomeIndicacao.removeAttribute("disabled");
            }
        });
    }

    /**Botão pergunta de confirmação para cancelar agendamento*/
    var botoesCancelar = document.querySelectorAll('.btnCancelaConsulta');

    botoesCancelar.forEach(function (botao) {
        botao.addEventListener('click', function (event) {
            var idConsulta = botao.getAttribute('data-id');
            var resposta = confirmarCancelamento(idConsulta);

            if (!resposta) {
                event.preventDefault();
            }
        });
    });

    function confirmarCancelamento(idConsulta) {
        return confirm("Tem certeza que deseja cancelar a consulta?");
    }

    /**Colocando data mínima aceita (Pessoas com 18 anos ou mais)*/
    var dataAtual = new Date();
    var idadeMinima = 18;
    var txtNascimento = document.getElementById('txtNascimento');

    if (txtNascimento) {
        dataAtual.setFullYear(dataAtual.getFullYear() - idadeMinima);
        var dataMinima = dataAtual.toISOString().split('T')[0];
        document.getElementById('txtNascimento').setAttribute('max', dataMinima);
    }

    /**Colocando datas e horários válidos para agendamento (Apenas após a data e hora atuais)*/
    function validarDataHorario() {
        var dataHoraAgendamento = new Date(document.getElementById('txtDataHora').value);
        var dataAtual = new Date();

        if (dataHoraAgendamento <= dataAtual) {
            alert("Por favor, selecione uma data e horário válidos.");
            return false;
        }
        return true;
    }

    var formAgendamento = document.getElementById('formAgendamento');

    if (formAgendamento) {
        document.getElementById('formAgendamento').addEventListener('submit', function (event) {
            if (!validarDataHorario()) {
                event.preventDefault();
            }
        });
    }
});