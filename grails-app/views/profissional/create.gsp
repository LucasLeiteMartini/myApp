<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastrar Profissional</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}">
</head>
<body>
    <div class="container">
        <h2>Cadastrar Profissional</h2>

        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:form controller="profissional" action="save" method="POST">
            <label for="nome">Nome:</label>
            <g:textField name="nome" required="true"/>

            <label for="crm">CRM:</label>
            <g:textField name="crm" required="true"/>

            <label for="especialidade">Especialidade:</label>
            <g:textField name="especialidade" required="true"/>

            <g:submitButton name="cadastrar" value="Cadastrar" class="btn"/>
        </g:form>
    </div>
</body>
</html>