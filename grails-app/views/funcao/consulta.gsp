<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Consultar Função</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>
<body>
    <div class="container">
        <h2>Consultar Função</h2>

        <form action="${createLink(controller: 'funcao', action: 'search')}" method="post">
            <input type="text" id="authority" name="authority" required />

            <button class="btn" type="submit">Buscar</button>
        </form>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:if test="${funcao}">
            <h3>Função:</h3>
            <p><strong></strong> ${funcao.authority}</p>
        </g:if>

        <p><a href="/funcao/create">Voltar</a></p>
    </div>
</body>
</html>
