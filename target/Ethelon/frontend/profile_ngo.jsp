<html>

    <%@include file="includes/head.jsp"%>
    <%@include file="includes/navbar.jsp"%>

<body>
<f:view>
<hr>
<div class="container bootstrap snippet">
    <div class="row">
        <div class="col-sm-10"><h1><h:outputText value = "#{ngocontr.ngoDto.organizationName}" /> </h1></div>
        <%--<div class="col-sm-2"><a href="/users" class="pull-right"><img title="profile image" class="img-circle img-responsive" src="http://www.ethelon.org/wp-content/uploads/2016/12/logo.png"></a></div>--%> <%--logo--%>
    </div>
    <div class="row">
        <div class="col-sm-3"><!--left col-->

            <ul class="list-group">
                <li class="list-group-item text-muted">Προφίλ</li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Όνομα Χρήστη</strong></span>  <h:outputText value = "#{ngocontr.ngoDto.username}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Όνομα Οργανισμού</strong></span> <h:outputText value = "#{ngocontr.ngoDto.organizationName}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Email</strong></span> <h:outputText value = "#{ngocontr.ngoDto.email}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Ιστοσελίδα</strong></span> <h:outputText value = "#{ngocontr.ngoDto.webpage}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Χώρα</strong></span> <h:outputText value = "#{ngocontr.ngoDto.country}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Διεύθυνση</strong></span> <h:outputText value = "#{ngocontr.ngoDto.address}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Τηλέφωνο</strong></span> <h:outputText value = "#{ngocontr.ngoDto.telephone}"/></li>
                <li class="list-group-item text-right"><span class="pull-left"><strong>Περιγραφή Οργανισμού</strong></span> <h:outputText value = "#{ngocontr.ngoDto.descGreek}"/></li>
                <button type="button" data-toggle="modal"><div class="pull-left"><span class="glyphicon glyphicon-edit"></span></div></button>
            </ul>

        </div>
        <div class="col-sm-9">

            <ul class="nav nav-tabs" id="myTab">
                <li class="active"><a href="#open" data-toggle="tab">Ανοιχτές Εθελοντικές Θέσεις</a></li>
                <li><a href="#history" data-toggle="tab">Ιστορικό</a></li>
                <li><a href="#new" data-toggle="tab">Ανάρτηση Εθελοντικής Θέσης</a></li>
            </ul>

            <div class="tab-content">
                <div class="tab-pane active" id="open">

                    <h2></h2>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Όνομα Αίτησης</th>
                                <th>Ημερομηνία Λήξης</th>
                                <th>Αριθμός Αιτήσεων</th>
                            </tr>
                            </thead>
                            <tbody id="items">
                            <tr data-toggle="collapse" data-target="#demo1" class="accordion-toggle ">
                                <td>Δημιουργία Ιστοσελίδας</td>
                                <td>18/06/2018</td>
                                <td>23</td>
                                <td><button type="button" data-toggle="modal" data-target="#edit" class="update btn btn-warning btn-sm"><span class="glyphicon glyphicon-pencil"></span></button></td>
                                <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>

                            </tr>

                            </tbody>

                        </table>

                    </div>

                    <hr>

                </div>
                <div class="tab-pane" id="history">

                    <h2></h2>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>Όνομα Αίτησης</th>
                                <th>Ημερομηνία Λήξης</th>
                                <th>Αριθμός Αιτήσεων</th>
                                <th>Κατάσταση</th>
                            </tr>
                            </thead>
                            <tbody id="items">
                            <tr>

                                <td>Δημιουργία Ιστοσελίδας</td>
                                <td>18/06/2017</td>
                                <td>2</td>
                                <td></td>
                                <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>

                            </tr>


                            </tbody>
                        </table>
                    </div>

                </div>

                <div class="tab-pane" id="new">
                    <h2></h2>

                    <div class="table-responsive">
                    <div class="container">
                        <div class="container">
                            <div class="col-md-5">
                                <div class="form-area">
                                    <form role="form">
                                        <br style="clear:both">
                                        <div class="form-group">
                                            <h4>Απαραίτητες Πληροφορίες Εθελοντη </h4>
                                            <textarea class="form-control" type="textarea" id="information" placeholder="Όνομα, Τηλέφωνο, Email"  rows="7" required></textarea>

                                        </div>
                                        <div class="form-group">
                                            <h4>Τίτλος Εθελοντικής Θέσης</h4>
                                            <input type="text" class="form-control" id="title" name="title" placeholder="" required>
                                        </div>
                                        <div class="form-group">
                                            <h4>Περιοχή</h4>
                                            <select id="area" name="area" class="form-control">
                                                <option value="1">Option one</option>
                                                <option value="2">Option two</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <h4>Περιγραφή Θέσης</h4>
                                            <textarea class="form-control" type="textarea" id="disc" placeholder=""  rows="7" required></textarea>

                                        </div>
                                        <div class="form-group">
                                            <h4>Ωράριο</h4>
                                            <input type="text" class="form-control" id="schedule" name="schedule" placeholder="Ημέρες/Ωρες" required>
                                        </div>
                                        <div class="form-group">
                                            <h4>Προσφέρονται</h4>
                                            <input type="textarea" class="form-control" id="offered" name="offered" placeholder="Ευχάριστο Περιβάλλον, Δυνατότητα Εξέλιξης" rows="4" required>
                                        </div>
                                        <div class="form-group">
                                            <h4>Επιθυμητές Γνώσεις </h4>
                                            <textarea class="form-control" type="textarea" id="skills" placeholder=""  rows="4" required></textarea>
                                        </div>
                                        <div class="form-group">
                                            <h4>Παρέχεται Εκπαίδευση </h4>
                                                <label>
                                                    <input type="radio" name="radioTrain" id="trainingY" value="Ναι" >
                                                    Ναι
                                                </label>
                                                <label>
                                                    <input type="radio" name="radioTrain" id="trainingN" value="Όχι" checked="checked">
                                                    Όχι

                                                </label>
                                            </div>
                                        <div class="form-group">
                                            <h4>Παρέχεται Βεβαίωση Εθελοντή </h4>
                                            <label>
                                                <input type="radio" name="radioCert" id="certificateY" value="Ναι" >
                                                Ναι
                                            </label>
                                            <label >
                                                <input type="radio" name="radioCert" id="certificateN" value="Όχι" checked="checked">
                                                Όχι
                                            </label>
                                        </div>
                                        <div class="form-group">
                                            <h4>Υπεύθυνος Επικοινωνίας</h4>
                                            <input type="text" class="form-control" id="responsible" placeholder="" required>
                                        </div>

                                        <div class="form-group">
                                            <h4>Προαιρετικές Ερωτήσεις Προς Εθελοντή</h4>
                                            <textarea class="form-control" type="textarea" id="optionalQ" placeholder=""  rows="7"></textarea>

                                        </div>
                                        <div class="form-group">

                                                <br>
                                                <button class="btn btn-lg btn-success" type="submit"><i class="glyphicon glyphicon-ok-sign"></i> Ανάρτηση </button>
                                                <button class="btn btn-lg" type="reset"><i class="glyphicon glyphicon-repeat"></i> Επαναφορά </button>
                                            </div>


                                    </form>
                                </div>
                            </div>
                        </div>
            </div>

                            </div>
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