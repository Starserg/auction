<#macro page>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="UTF-8">
    <title>AUCTION</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="/static/css/bootstrap.css">

    <link rel="stylesheet" href="/static/css/main.css">
</head>
<body>
    <#include "navbar.ftl">
    <#nested >
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->

<script src="/static/js/jquery-3.3.1.js"></script>
<#--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"
        integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ"
        crossorigin="anonymous"></script>
<script src="/static/js/bootstrap.js"></script>
<script defer src="https://use.fontawesome.com/releases/v5.0.10/js/all.js"
        integrity="sha384-slN8GvtUJGnv6ca26v8EzVaR9DC58QEwsIk9q1QXdCU8Yu8ck/tL/5szYlBbqmS+"
        crossorigin="anonymous"></script>
<script src="/static/js/main.js"></script>
</body>
</html>
</#macro>


<#macro footer>
    <!-- Footer -->
<footer class="page-footer font-small blue pt-4 mt-4 text-light">

    <!-- Footer Links -->
    <div class="container-fluid text-center text-md-left">

        <!-- Grid row -->
        <div class="row">

            <!-- Grid column -->
            <div class="col-md-6 mt-md-0 mt-3">

                <!-- Content -->
                <h5 class="text-uppercase">Footer Content</h5>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. A architecto consectetur eveniet, excepturi
                    numquam pariatur quas sunt tenetur unde vero!</p>

            </div>
            <!-- Grid column -->

            <hr class="clearfix w-100 d-md-none pb-3">

            <!-- Grid column -->
            <div class="col-md-6 mb-md-0 mb-3">

                <!-- Links -->
                <h5 class="text-uppercase">Links</h5>

                <ul class="list-unstyled">
                    <li>
                        <a class="blue" href="#!">Link 1</a>
                    </li>
                    <li>
                        <a class="blue" href="#!">Link 2</a>
                    </li>
                    <li>
                        <a class="blue" href="#!">Link 3</a>
                    </li>
                    <li>
                        <a class="blue" href="#!">Link 4</a>
                    </li>
                </ul>

            </div>
            <!-- Grid column -->

        </div>
        <!-- Grid row -->

    </div>
    <!-- Footer Links -->

    <!-- Copyright -->
    <div class="footer-copyright text-center py-3 blueDark">© 2018
        <a> Rgr</a>
    </div>
    <!-- Copyright -->

</footer>
<!-- Footer -->
</#macro>