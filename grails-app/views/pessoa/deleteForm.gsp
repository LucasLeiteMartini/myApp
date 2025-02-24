<!DOCTYPE html>
<html>
<head>
    <title>Excluir Pessoa</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="/assets/bootstrap.css">
</head>
<body>

    <div class="container">
        <h2>Excluir Pessoa</h2>

        <g:if test="${flash.message}">
            <div class="alert alert-success">${flash.message}</div>
        </g:if>

        <g:if test="${flash.error}">
            <div class="alert alert-danger">${flash.error}</div>
        </g:if>

        <g:form controller="pessoa" action="delete" method="POST" class="form">
            <div class="form-group">
                <label>ID da Pessoa:</label>
                <g:textField name="id" type="number" class="form-control" required="true"/>
            </div>

            <button type="submit" class="btn btn-danger">Excluir</button>
        </g:form>
    </div>

</body>
</html>
