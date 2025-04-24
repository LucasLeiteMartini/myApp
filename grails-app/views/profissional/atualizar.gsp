<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Atualizar Profissional</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}">
</head>
<body>
    <div class="container">
        <h2>Atualizar por CRM</h2>

        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:form controller="profissional" action="search" method="post">
            <label for="crm">CRM:</label>
            <g:textField name="crm" required="true"/>
            <input type="hidden" name="origem" value="atualizar"/>
            <g:submitButton name="buscar" value="Buscar Pessoa" class="btn"/>
        </g:form>


        <g:if test="${profissional}">
            <g:form controller="profissional" action="update" method="post">
                <label for="crm">CRM</label>
                <input type="text" name="crm" id="crm" value="${profissional.getCrm()}">

                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" value="${profissional.getNome()}">

                <label for="especialidade">Especialidade</label>
                <input type="text" name="especialidade" id="especialidade" value="${profissional.getEspecialidade()}">

                <button type="submit" class="btn">Atualizar cadastro</button>
            </g:form>
        </g:if>
    </div>
</body>
</html>
