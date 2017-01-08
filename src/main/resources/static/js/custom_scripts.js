$('#confirmacaoExclusaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codigoAluno = button.data('codigo');
	var nomeAluno = button.data('nome');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codigoAluno);
	
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o aluno <strong>' + nomeAluno + '</strong>?');
});

$(document).ready(function() {
	// $('#cpf').mask('000.000.000-00', {reverse: true});	
});