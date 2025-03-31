<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastro de Pessoa</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>
<body>
<div class="container">
    <img src="/home/lucas/myapp/grails-app/assets/images/telessaude_logo.png" width="100" />
    <h2>Cadastro de Pessoa</h2>

    <g:if test="${flash.error}">
        <div class="error">${flash.error}</div>
    </g:if>

    <g:if test="${flash.message}">
        <div class="success">${flash.message}</div>
    </g:if>

    <g:form controller="usuario" action="save" method="POST">
        <label for="username">Nome de Usuário</label>
        <input type="text" id="username" name="username" required/>

        <label for="password">Senha</label>
        <input type="password" id="password" name="password" required/>


        <button type="submit" class="btn">Finalizar Cadastro</button>
    </g:form>

</div>
</body>
</html>
