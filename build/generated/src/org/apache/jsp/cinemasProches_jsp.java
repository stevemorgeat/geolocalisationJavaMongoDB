package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class cinemasProches_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"/MongoDBWeb/css/main.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"/MongoDBWeb/css/bootstrap.min.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"/MongoDBWeb/jquery/jquery-ui.css\" />\n");
      out.write("        <script src=\"/MongoDBWeb/jquery/jquery.js\"></script>\n");
      out.write("        <script src=\"/MongoDBWeb/jquery/jquery-ui.js\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <div class=\"row\">  \n");
      out.write("            <div class=\"col-md-4 col-md-offset-1\">\n");
      out.write("                <form id=\"formulaireCinemaProche\" class=\"form-group\" method=\"GET\" action=\"\">\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"\">Recherche cinéma proche : </label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" name=\"recherche\" id=\"recherche\" class=\"form-control\" placeholder=\"taper votre cinéma ici\" />\n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"\">Périmètre : </label>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <input type=\"text\" name=\"distance\" id=\"distance\" class=\"form-control\" placeholder=\"1000\" value=\"1000\" />\n");
      out.write("                    </div> \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <button type=\"button\" id=\"btSubmit\" class=\"btn btn-primary\">Valider</button>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-md-4 col-md-offset-1\">\n");
      out.write("\n");
      out.write("                <h3>Géo Map Dynamique HTML5</h3>\n");
      out.write("                <div id=\"divMap\"></div>\n");
      out.write("                <p>\n");
      out.write("                    <label id=\"lblMessage\">Message</label>\n");
      out.write("                </p>\n");
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script src=\"http://maps.google.com/maps/api/js?key=AIzaSyD07327vXN54GrtvToNdXXAMWGa-C-AnUI&libraries=weather\"></script>\n");
      out.write("        <script src=\"/MongoDBWeb/js/bootstrap.min.js\"></script>\n");
      out.write("        <script src=\"/MongoDBWeb/js/main.js\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
