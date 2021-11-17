$(document).ready(function() {
    $("#show").click(function() {
      console.log("running test click);
      event.preventDefault();
      $.get("http://localhost:63342/bootcamp_project/02-shop-microservice/public/index.html?", function(books) {
            console.log(books);

            let html = "<p>test<p>";

            $("#booklist").append($(html));
      });
    });
  });