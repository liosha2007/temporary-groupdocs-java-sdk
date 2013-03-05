<html>
  <head>
    <title>${project.name}</title>
    <script src='right.js'></script>
    <script type='text/javascript'>
      //<![CDATA[
        "#annotations".onClick(function(event) {
          event.stop();
          $('annotations_list').load("/annotation");
        });
      //]]>
    </script>
  </head>
  <body>
    <iframe frameborder='0' src='https://apps.groupdocs.com/document-annotation/Embed/<%=session.getAttribute("fileGuid")%>' width='720' height='600'></iframe>
    <br />
    <br />
    <button id='annotations'>Poll annotations</button>
    <br />
    <br />
    <div id='annotations_list'></div>
  </body>
</html>
