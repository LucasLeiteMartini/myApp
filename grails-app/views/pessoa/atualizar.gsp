<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Atualizar Pessoa</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}">
</head>
<body>
    <div class="container">
        <h2>Atualizar por CNS</h2>

        <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:form controller="pessoa" action="search" method="post">
            <label for="cns">CNS:</label>
            <g:textField name="cns" required="true"/>
            <input type="hidden" name="origem" value="atualizar"/>
            <g:submitButton name="buscar" value="Buscar Pessoa" class="btn"/>
        </g:form>


        <g:if test="${pessoa}">
            <g:form controller="pessoa" action="update" method="post">
                <label for="cns">CNS</label>
                <input type="text" name="cns" id="cns" value="${pessoa.getCns()}">

                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" value="${pessoa.getNome()}">

                <label for="idade">Idade</label>
                <input type="number" name="idade" id="idade" value="${pessoa.getIdade()}">

                <label for="endereco">Endereco</label>
                <input type="text" name="endereco" id="endereco" value="${pessoa.getEndereco()}">

                <button type="submit" class="btn">Atualizar cadastro</button>
            </g:form>
        </g:if>
    </div>
</body>
</html>
