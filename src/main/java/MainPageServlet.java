import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MainPageServlet", urlPatterns = {"/"})
public class MainPageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\"");
        out.println("      xmlns:h=\"http://xmlns.jcp.org/jsf/html\"");
        out.println("      xmlns:f=\"http://xmlns.jcp.org/jsf/core\"");
        out.println("      xmlns:p=\"http://primefaces.org/ui\">");
        out.println("<h:head>");
        out.println("    <title>Listagem de Pessoas</title>");
        out.println("</h:head>");
        out.println("<h:body>");
        out.println("    <h1>Listagem de Pessoas</h1>");
        out.println("    <p:dataTable value=\"#{pessoaBean.pessoas}\" var=\"pessoa\" styleClass=\"primefaces-table\">");
        out.println("        <!-- Colunas da tabela -->");
        out.println("        <p:column headerText=\"ID\">");
        out.println("            <h:outputText value=\"#{pessoa.id}\" />");
        out.println("        </p:column>");
        out.println("        <p:column headerText=\"Nome\">");
        out.println("            <h:outputText value=\"#{pessoa.nome}\" />");
        out.println("        </p:column>");
        out.println("        <p:column headerText=\"Idade\">");
        out.println("            <h:outputText value=\"#{pessoa.idade}\" />");
        out.println("        </p:column>");
        out.println("        <p:column headerText=\"Sexo\">");
        out.println("            <h:outputText value=\"#{pessoa.sexo}\" />");
        out.println("        </p:column>");
        out.println("        <!-- Botões de ação -->");
        out.println("        <p:column headerText=\"Ações\">");
        out.println("            <p:commandButton value=\"Editar\" action=\"#{pessoaBean.editarPessoa}\" update=\":formPessoa\" />");
        out.println("            <p:commandButton value=\"Excluir\" action=\"#{pessoaBean.excluirPessoa}\" update=\":formPessoa\" />");
        out.println("        </p:column>");
        out.println("    </p:dataTable>");
        out.println("    <h1>Listagem de Pessoas</h1>");
        out.println("</h:body>");
        out.println("</html>");
        out.close();
    }

}
