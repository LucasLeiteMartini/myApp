<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastro de Função</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>
<body>
<div class="container">
    <img src="${resource(dir: 'images', file: 'telessaude_logo.png')}" width="100" />
    <h2>Cadastro de Função</h2>

    <g:if test="${flash.error}">
        <div class="error">${flash.error}</div>
    </g:if>

    <g:if test="${flash.message}">
        <div class="success">${flash.message}</div>
    </g:if>

    <g:form controller="funcao" action="save" method="POST">
        <label for="authority">Nome da Função</label>
        <input type="text" id="authority" name="authority" required/>
        <button type="submit" class="btn">Finalizar Cadastro</button>
    </g:form>

</div>
</body>
</html>
