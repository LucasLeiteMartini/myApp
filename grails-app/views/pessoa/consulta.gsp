<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Consulta de Pessoa</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>
<body>
    <div class="container">
        <h2>Consultar Pessoa pelo CNS</h2>

        <form action="${createLink(controller: 'pessoa', action: 'search')}" method="post">
            <label for="cns">CNS</label>
            <input type="text" id="cns" name="cns" required />

            <button class="btn" type="submit">Buscar</button>
        </form>

        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>

        <g:if test="${pessoa}">
            <h3>Dados da Pessoa</h3>
            <p><strong>Nome:</strong> ${pessoa.nome}</p>
            <p><strong>Idade:</strong> ${pessoa.idade}</p>
            <p><strong>Endereço:</strong> ${pessoa.endereco}</p>
            <p><strong>CNS:</strong> ${pessoa.cns}</p>
        </g:if>

        <p><a href="/pessoa/create">Voltar</a></p>
    </div>
</body>
</html>
