<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Excluir Profissional</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}">
</head>
<body>
    <div class="container">
        <h2>Excluir Profissional por CRM</h2>

        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:form controller="profissional" action="buscarPorCrm" method="GET">
            <label for="crm">CRM:</label>
            <g:textField name="crm" required="true"/>
            <input type="hidden" name="origem" value="delete"/>
            <g:submitButton name="buscar" value="Buscar Profissional" class="btn"/>
        </g:form>

        <g:if test="${profissional}">
            <div class="container">
                <h3>Confirmar Exclusão</h3>
                <p><strong>Nome:</strong> ${profissional.nome}</p>
                <p><strong>CRM:</strong> ${profissional.crm}</p>
                <p><strong>Especialidade:</strong> ${profissional.especialidade}</p>

                <g:form controller="profissional" action="delete" method="POST">
                    <input type="hidden" name="crm" value="${profissional.crm}"/>
                    <g:submitButton name="confirmar" value="Confirmar Exclusão" class="btn"/>
                </g:form>
            </div>
        </g:if>
    </div>
</body>
</html>