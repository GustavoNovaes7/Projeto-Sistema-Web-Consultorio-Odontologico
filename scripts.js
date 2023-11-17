document.addEventListener("DOMContentLoaded", function () {

    /**Botão 'Atualizar Informações' - Tela Sua Conta*/
    var btnAtualizar = document.getElementById("btnAtualizar");

    if (btnAtualizar) {
        btnAtualizar.addEventListener("click", function () {
            habilitarCampos();
        });
    }


    function habilitarCampos() {
        var inputs = document.querySelectorAll("input, select");
        inputs.forEach(function (input) {
            input.removeAttribute("disabled");
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
            if (slctIndicacao.value != 1) {
                txtNomeIndicacao.setAttribute("disabled", true);
                txtNomeIndicacao.value = "";
            } else {
                txtNomeIndicacao.removeAttribute("disabled");
            }
        });
    }
});