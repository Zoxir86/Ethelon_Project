<%@ page import="com.frontend_components.OpportunityCard" %>
<%@ page import="com.dto.OpportunityDTO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.Utilities" %>
<%@ page import="com.dao.OpportunityDAOImplementation" %>
<%@ page import="com.database.Interest" %>
<%@ page import="com.dao.InterestDAOImplementation" %>
<%@ page import="com.dto.InterestDTO" %>
<%@ page import="com.dto.NgoDTO" %>
<%@ page import="com.dao.AreaDAOImplementation" %>
<%@ page import="com.dto.AreaDTO" %>

<!DOCTYPE html>
<html>
<style>
</style>
<head>
    <meta charset="UTF-8">
    <title>Article News Card</title>
    <script src="//use.typekit.net/xyl8bgh.js"></script>
    <script>try{Typekit.load();}catch(e){}</script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans:400,400i&amp;subset=greek,greek-ext" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300i,400&amp;subset=greek,greek-ext" rel="stylesheet">
    <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css'>
    <link rel='stylesheet prefetch' href='css/__codepen_io_andytran_pen.css'>
    <link rel="stylesheet" href="css/style.css">


    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

</head>


<body>

<%@ page contentType="text/html; charset=UTF-8" %>

<div class="container">

    <div class="w3-panel w3-card" style="margin-bottom:50px; text-align:center; font-family: Roboto Condensed, sans-serif; font-size:small">
        <div id="myBtnContainer">
            <button class="btn active" onclick="filterSelection('all')">Όλα</button>
            <button class="btn" onclick="filterSelection('animals')">Ζώα</button>
            <button class="btn" onclick="filterSelection('tech')">Eυπαθείς Ομάδες</button>
            <button class="btn" onclick="filterSelection('health')">Υγεία</button>
            <button class="btn" onclick="filterSelection('tech')">Περιβάλλον</button>
            <button class="btn" onclick="filterSelection('tech')">ΑμεΑ</button>
            <button class="btn" onclick="filterSelection('tech')">Πολιτισμός και Τέχνη</button>
            <button class="btn" onclick="filterSelection('tech')">Άτομα Μεγαλύτερης Ηλικίας</button>
            <button class="btn" onclick="filterSelection('chil')">Παιδιά</button>
            <button class="btn" onclick="filterSelection('tech')">Πρόσφυγες</button>
            <button class="btn" onclick="filterSelection('tech')">Εκπαίδευση</button>
            <button class="btn" onclick="filterSelection('tech')">Άλλο</button>
        </div>
    </div>

    <%
        String h = "";
        OpportunityDAOImplementation odi = new OpportunityDAOImplementation();
        ArrayList<OpportunityDTO> list = odi.getFullListOfOpportunities();
        if(list != null) {
            for(int o = 0; o < list.size(); o++) {
                OpportunityCard card = new OpportunityCard(list.get(o));
                h = h.concat(card.printCard());
                h = h.concat("\n");
            }
        }
    %>
    <p><%= h %></p>

    <div class="filterDiv animals">
        <div class="column">
            <div class="demo-title">&#922;&#913;&#921;&#931;&#913;&#929;&#921;&#913;&#925;&#919;, &#913;&#932;&#932;&#921;&#922;&#919;</div>
            <!-- Post-->
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">05</div>
                        <div class="month">&#924;&#913;&#938;</div>
                    </div><img src="http://training-dogs.biz/wp-content/uploads/2009/01/adopt-a-puppy.jpg"/>
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category" style="top: -34px; margin-top: 0">&#918;&#937;&#913;</div>
                    <h1 class="title">&#934;&#949;&#963;&#964;&#953;&#946;&#940;&#955; &#933;&#953;&#959;&#952;&#949;&#963;&#943;&#945;&#962; &#913;&#948;&#941;&#963;&#960;&#959;&#964;&#969;&#957;</h1>
                    <h2 class="sub_title">&#934;&#953;&#955;&#959;&#950;&#969;&#970;&#954;&#942; &#917;&#964;&#945;&#953;&#961;&#949;&#943;&#945;</h2>
                    <p class="description">&#927;&#953; &#956;&#953;&#954;&#961;&#959;&#943; &#956;&#945;&#962; &#966;&#943;&#955;&#959;&#953; &#967;&#961;&#949;&#953;&#940;&#950;&#959;&#957;&#964;&#945;&#953; &#941;&#957;&#945; &#957;&#941;&#959; &#963;&#960;&#943;&#964;&#953; &#954;&#945;&#953; &#949;&#963;&#973; &#956;&#960;&#959;&#961;&#949;&#943;&#962; &#957;&#945; &#946;&#959;&#951;&#952;&#942;&#963;&#949;&#953;&#962;! &#917;&#943;&#963;&#945;&#953; &#954;&#964;&#951;&#957;&#943;&#945;&#964;&#961;&#959;&#962; &#942; &#945;&#960;&#955;&#974;&#962; &#941;&#956;&#960;&#949;&#953;&#961;&#959;&#962; &#963;&#964;&#951; &#966;&#961;&#959;&#957;&#964;&#943;&#948;&#945; &#954;&#945;&#964;&#959;&#953;&#954;&#953;&#948;&#943;&#969;&#957;; &#933;&#960;&#940;&#961;&#967;&#949;&#953; &#956;&#943;&#945; &#952;&#941;&#963;&#951; &#947;&#953;&#945; &#949;&#963;&#941;&#957;&#945;!</p>
                    <div class="post-meta" align="right"><span class="timestamp">

        <i class="fa fa-id-card-o"></i><a href="#"> &#928;&#949;&#961;&#953;&#963;&#963;&#972;&#964;&#949;&#961;&#945;...</a></span></div>
                </div>
            </div>
        </div>
    </div>


    <div class="filterDiv tech">
        <div class="column tech">
            <div class="demo-title">&#920;&#917;&#931;&#931;&#913;&#923;&#927;&#925;&#921;&#922;&#919;, &#920;&#917;&#931;&#931;&#913;&#923;&#927;&#925;&#921;&#922;&#919;</div>
            <!-- Post-->
            <div class="post-module">
                <!-- Thumbnail-->
                <div class="thumbnail">
                    <div class="date">
                        <div class="day">01</div>
                        <div class="month">&#924;&#913;&#938;</div>
                    </div><img src="http://www.ethelon.org/wp-content/uploads/2018/04/arduino-day.jpg"/>
                </div>
                <!-- Post Content-->
                <div class="post-content">
                    <div class="category">&#932;&#917;&#935;&#925;&#927;&#923;&#927;&#915;&#921;&#913;</div>
                    <h1 class="title">Arduino Day Thessaloniki 2018</h1>
                    <h2 class="sub_title">SheSharp Greece</h2>
                    <p class="description">H Arduino Day, &#945;&#960;&#959;&#964;&#949;&#955;&#949;&#943; &#956;&#943;&#945; &#949;&#964;&#942;&#963;&#953;&#945; &#960;&#945;&#947;&#954;&#972;&#963;&#956;&#953;&#945; &#951;&#956;&#949;&#961;&#943;&#948;&#945; &#947;&#953;&#945; &#964;&#959;&#957; &#949;&#959;&#961;&#964;&#945;&#963;&#956;&#972; &#964;&#951;&#962; &#960;&#955;&#945;&#964;&#966;&#972;&#961;&#956;&#945;&#962; &#945;&#957;&#959;&#953;&#967;&#964;&#959;&#973; &#955;&#959;&#947;&#953;&#963;&#956;&#953;&#954;&#959;&#973; &#954;&#945;&#953; &#965;&#955;&#953;&#963;&#956;&#953;&#954;&#959;&#973; Arduino! &#919; &#948;&#953;&#959;&#961;&#947;&#940;&#957;&#969;&#963;&#951; &#960;&#961;&#945;&#947;&#956;&#945;&#964;&#959;&#960;&#959;&#953;&#949;&#943;&#964;&#945;&#953; &#947;&#953;&#945; 3&#951; &#967;&#961;&#959;&#957;&#953;&#940; &#963;&#964;&#951;&#957; &#920;&#949;&#963;&#963;&#945;&#955;&#959;&#957;&#943;&#954;&#951; &#945;&#960;&#972; &#964;&#951;&#957; SheSharp Greece. &#919; Ethelon &#952;&#945; &#948;&#974;&#963;&#949;&#953; &#964;&#959; &#960;&#945;&#961;&#972;&#957; &#963;&#964;&#951;&#957; &#949;&#954;&#948;&#942;&#955;&#969;&#963;&#951; &#945;&#965;&#964;&#942; &#956;&#949; &#964;&#959;&#965;&#962; &#949;&#952;&#949;&#955;&#959;&#957;&#964;&#941;&#962; &#964;&#951;&#962; &#954;&#945;&#953; &#963;&#949; &#954;&#945;&#955;&#949;&#943; &#957;&#945; &#960;&#940;&#961;&#949;&#953;&#962; &#956;&#941;&#961;&#959;&#962;!</p>
                    <div class="post-meta" align="right"><span class="timestamp">
        <i class="fa fa-id-card-o"></i><a href="#"> &#928;&#949;&#961;&#953;&#963;&#963;&#972;&#964;&#949;&#961;&#945;...</a></span></div>
                </div>
            </div>
        </div>
    </div>

</div>



<script>
    filterSelection("all")
    function filterSelection(c) {
        var x, i;
        x = document.getElementsByClassName("filterDiv");
        if (c == "all") c = "";
        for (i = 0; i < x.length; i++) {
            w3RemoveClass(x[i], "show");
            if (x[i].className.indexOf(c) > -1) w3AddClass(x[i], "show");
        }
    }

    function w3AddClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            if (arr1.indexOf(arr2[i]) == -1) {element.className += " " + arr2[i];}
        }
    }

    function w3RemoveClass(element, name) {
        var i, arr1, arr2;
        arr1 = element.className.split(" ");
        arr2 = name.split(" ");
        for (i = 0; i < arr2.length; i++) {
            while (arr1.indexOf(arr2[i]) > -1) {
                arr1.splice(arr1.indexOf(arr2[i]), 1);
            }
        }
        element.className = arr1.join(" ");
    }

    // Add active class to the current button (highlight it)
    var btnContainer = document.getElementById("myBtnContainer");
    var btns = btnContainer.getElementsByClassName("btn");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function(){
            var current = document.getElementsByClassName("active");
            current[0].className = current[0].className.replace(" active", "");
            this.className += " active";
        });
    }
</script>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
<script src="js/index.js"></script>


</body>
</html>
