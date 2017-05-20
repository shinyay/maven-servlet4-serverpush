<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Responsive viewport for smartphone devices -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- least.js 2 CSS file -->
        <link href="css/least.min.css" rel="stylesheet" />
        <title>ギャラリー</title>
    </head>
    <body>
        <!-- Least Gallery -->
        <section id="least">

            <!-- Least Gallery: Fullscreen Preview -->
            <div class="least-preview"></div>

            <!-- Least Gallery: Thumbnails -->
            <ul class="least-gallery">
                <li>
                    <a href="images/dog1.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog1.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog2.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog2.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog3.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog3.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog4.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog4.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog5.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog5.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog6.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog6.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog7.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog7.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog8.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog8.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog9.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog9.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog10.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog10.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog11.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog11.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog12.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog12.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog13.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog13.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog14.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog14.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog15.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog15.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog16.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog16.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog17.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog18.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog18.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog18.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog19.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog19.jpg" alt="Alt Image Text" />
                    </a>
                </li>
                <li>
                    <a href="images/dog20.jpg" data-subtitle="View Picture" >
                        <img src="images/s-dog20.jpg" alt="Alt Image Text" />
                    </a>
                </li>
            </ul>

        </section>
        <!-- Least Gallery end -->

        <!-- jQuery library -->
        <script src="js/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- least.js 2 library -->
        <script src="js/libs/least/least.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.least-gallery').least();
            });
        </script>
    </body>
</html>
