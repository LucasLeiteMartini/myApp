<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Excluir Pessoa</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}">
</head>
<body>
    <div class="container">
        <h2>Excluir Pessoa por CNS</h2>

        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:form controller="pessoa" action="search" method="GET">
            <label for="cns">CNS:</label>
            <g:textField name="cns" required="true"/>
            <input type="hidden" name="origem" value="delete"/>
            <g:submitButton name="buscar" value="Buscar Pessoa" class="btn"/>
        </g:form>
        

        <g:if test="${pessoa}">
            <div class="container">
                <h3>Confirmar Exclusão</h3>
                <p><strong>Nome:</strong> ${pessoa.nome}</p>
                <p><strong>CNS:</strong> ${pessoa.cns}</p>
        
                <g:form controller="pessoa" action="delete" method="POST">
                    <input type="hidden" name="cns" value="${pessoa.cns}"/>
                    <g:submitButton name="excluir" value="Confirmar Exclusão" class="btn"/>
                </g:form>
            </div>
        </g:if>
    </div>
</body>
</html>
