<%-- 
    Document   : frmAlterarLivroView
    Created on : Jan 23, 2023, 7:31:28 PM
    Author     : Frederico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <nav class="navbar bg-light">
            <div class="container">
                <a href="/ProjetoBiblioteca/index.html" ><span class="navbar-brand mb-0 h1">Biblioteca</span></a>
            </div>
        </nav>
        <div class="container">
            <div>
                <h1>Editar Livro</h1>
            </div>
            <div class="col-md-3">
                <form action="editarLivroAction.jsp" method="POST">
                    <label class="form-label">Código do Livro</label><br/>
                    <input type="text" class="form-control" name="id" value="<%=request.getParameter("id")%>" />
                    <br/>

                    <label class="form-label">Nome</label><br/>
                    <input type="text" class="form-control" name="nome" value="<%=request.getParameter("nome")%>" />
                    <br/>

                    <button type="submit" class="btn btn-success">Salvar</button>
                </form>
            </div>
            
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    </body>
</html>
