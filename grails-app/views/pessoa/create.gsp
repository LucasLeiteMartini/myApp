<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Pessoa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.css">
</head>
<body>

    <div class="container">
        <h2>Cadastro de Pessoa</h2>

        <g:if test="${flash.message}">
            <div class="alert alert-success">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="alert alert-danger">${flash.error}</div>
        </g:if>

        <g:form controller="pessoa" action="save" method="POST" class="form">
            <div class="form-group">
                <label>Nome:</label>
                <g:textField name="nome" class="form-control" required="true"/>
            </div>

            <div class="form-group">
                <label>Idade:</label>
                <g:textField name="idade" type="number" class="form-control" required="true"/>
            </div>

            <div class="form-group">
                <label>Endereço:</label>
                <g:textField name="endereco" class="form-control" required="true"/>
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </g:form>
    </div>

</body>
</html>
