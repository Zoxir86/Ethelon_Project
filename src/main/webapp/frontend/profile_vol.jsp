<html>

    <%@include file="includes/head.jsp"%>
    <%@include file="includes/navbar.jsp"%>

<body>


<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1>Ανδρέας Ανδρέου </h1></div>
        <div class="col-sm-2"><a href="/users" class="pull-right"><img title="profile image" class="img-circle img-responsive" src="http://www.espacoacompanhar.com.br/espaco/assets/img/people/person-icon.png"></a></div>

    </div>
    <div class="row">

        <div class="col-sm-3">

            <ul class="list-group">
                <li class="list-group-item text-muted">Προφίλ </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Όνομα Χρήστη</strong></span> asdf123</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Email</strong></span> andreas@asdf.gr</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Όνομα</strong></span> Ανδρέας</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Επώνυμο</strong></span> Ανδρέου</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Ημερομηνία Γέννησης</strong></span> 12/12/12</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Περιοχή</strong></span> Μαρούσι</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Τηλέφωνο</strong></span> 69999999</li>

                <button type="button" data-toggle="modal"><div class="pull-left"><span class="glyphicon glyphicon-edit"></span></div></button>
            </ul>


        </div>
        <div class="col-sm-9">

            <ul class="nav nav-tabs" id="myTab">
                <li class="active"> <a href="#open" role="tab" data-toggle="tab">Τρέχουσες Αιτήσεις </a></li>
                <li class=""> <a href="#history" role="tab" data-toggle="tab">Ιστορικό</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="open">
                    <h2></h2>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Όνομα Αίτησης</th>
                                <th>Όνομα ΜΚΟ</th>
                                <th>Ημερομηνία Λήξης</th>
                                <th>Κατάσταση</th>

                            </tr>
                            </thead>
                            <tbody id="items">
                            <tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle ">
                                <td>Δημιουργία Ιστοσελίδας</td>
                                <td>Ethelon</td>
                                <td>18/06/2018</td>
                                <td>Ανοιχτή</td>
                                <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>
                            </tr>

                            </tbody>

                        </table>


                    </div>



                </div>
                <div class="tab-pane" id="history">

                    <h2></h2>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Όνομα Αίτησης</th>
                                <th>Όνομα ΜΚΟ</th>
                                <th>Ημερομηνία Λήξης</th>
                                <th>Κατάσταση</th>
                            </tr>
                            </thead>
                            <tbody id="items">
                            <tr>
                                <td>Δημιουργία Ιστοσελίδας</td>
                                <td>Ethelon</td>
                                <td>18/06/2017</td>
                                <td></td>
                                <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>

                            </tr>
                            </tbody>
                        </table>
                    </div>

                </div>


            </div>
        </div>

    </div>
</div>
<footer>
    <%@include file="includes/footer.jsp"%>
</footer>
</body>
</html>



