<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastro de Pessoa</title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'styles.css')}" />
</head>
<body>
    <div class="container">
        <img src="/images/telessaude_logo.png" width="100" />
        <h2>Cadastro de Pessoa</h2>
        
        <g:if test="${flash.error}">
            <div class="error">${flash.error}</div>
        </g:if>
        
        <g:if test="${flash.message}">
            <div class="success">${flash.message}</div>
        </g:if>
        
        <g:form action="save" method="POST">
            <label for="cns">CNS</label>
            <input type="text" id="cns" name="cns" required/>
            
            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome" required/>
            
            <label for="idade">Idade</label>
            <input type="number" id="idade" name="idade" min="0" required/>
            
            <label for="endereco">Endereço</label>
            <input type="text" id="endereco" name="endereco" required/>
            
            <h3>Termo de Consentimento Livre e Esclarecido</h3>
            <div class="toggle-group">
                <label><input type="radio" name="tipo" value="paciente" checked /> Paciente</label>
                <label><input type="radio" name="tipo" value="moderador" /> Moderador</label>
            </div>
            
            <button type="submit" class="btn">Finalizar Cadastro</button>
        </g:form>
        
        <p><a href="/login">Voltar à tela de login</a></p>
        <p><a href="/oauth">Login via Google/Outras plataformas</a></p>
    </div>
</body>
</html>
