<html>

    <%@include file="includes/head.jsp"%>
    <%@include file="includes/navbar.jsp"%>

<body>
<f:view>

<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1><h:outputText value = "#{volcontr.volunteerDto.name} #{volcontr.volunteerDto.surname}"   /> </h1></div>
        <%--<div class="col-sm-2"><a href="/users" class="pull-right"><img title="profile image" class="img-circle img-responsive" src="http://www.espacoacompanhar.com.br/espaco/assets/img/people/person-icon.png"></a></div>--%>

    </div>

    <div class="row">

        <div class="col-sm-3">

            <ul class="list-group">
                <li class="list-group-item text-muted">Προφίλ </li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Όνομα Χρήστη</strong></span>    <h:outputText value = "#{volcontr.volunteerDto.username}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Email</strong></span> <h:outputText value = "#{volcontr.volunteerDto.email}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Όνομα</strong></span>  <h:outputText value = "#{volcontr.volunteerDto.name}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Επώνυμο</strong></span> <h:outputText value = "#{volcontr.volunteerDto.surname}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Ημερομηνία Γέννησης</strong></span> <h:outputText value = "#{volcontr.volunteerDto.dateOfBirth}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Φύλο</strong></span><h:outputText value = "#{volcontr.volunteerDto.sex}"/></li>
                <%--<li class="list-group-item text-right"><span class="pull-left"><strong>Περιοχή</strong></span> <h:outputText value = "#{volcontr.volunteerDto.area}"/></li>--%>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Ενδιαφέροντα</strong></span><c:forEach items="${volcontr.volunteerDto.interestsList}" var="item"><c:out value= "${item.descriptionGreekLowerCase}"/> <br></c:forEach></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Γνώσεις</strong></span><c:forEach items="${volcontr.volunteerDto.knowledgeAreasList}" var="item"><c:out value= "${item.descriptionGreekLowerCase}"/> <br></c:forEach></li>

                <a href="edit_account.xhtml" class="glyphicon glyphicon-edit">Edit</a>
            </ul>


        </div>
        <div class="col-sm-9">

            <ul class="nav nav-tabs" id="myTab">
                <li class="active"> <a href="#open" role="tab" data-toggle="tab">Τρέχουσες Αιτήσεις </a></li>
                <li class=""> <a href="#history" role="tab" data-toggle="tab">Αιτήσεις σε Αναμονή</a></li>
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

                            </tr>
                            </thead>
                            <tbody id="items">
                            <tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle ">
                                <td> <h:outputText value = "#{oppcontr.opportunityDto}"/></td>

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
</f:view>
</body>
</html>



