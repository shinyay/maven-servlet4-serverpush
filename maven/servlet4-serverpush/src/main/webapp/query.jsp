<%
    String word = ("hello".equals(request.getHeader("headertest"))? "Hello" : "World");
    if (request.getSession() != null) {
        String info = (String)request.getSession().getValue("info");
        if (info != null) {
            word += info;
        }
        String queryString = request.getQueryString();
        if (queryString != null) {
            word += "|" + queryString;
        }
    }
    out.println(word);
%>