<html>
  <head>
    <title>${project.name}</title>
  </head>
  <body>
    <h4>Upload file</h4>
    <form action='/upload' enctype='multipart/form-data' method='post'>
      <label for='client_id'>GroupDocs Client ID</label>
      <br />
      <input name='client_id' type='text' />
      <br />
      <label for='private_key'>GroupDocs Private Key</label>
      <br />
      <input name='private_key' type='text' />
      <br />
      <label for='file'>File</label>
      <br />
      <input name='file' type='file' />
      <br />
      <br />
      <input type='submit' value='Upload' />
    </form>
  </body>
</html>
