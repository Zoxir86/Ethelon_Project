<style>
<%@ include file="/frontend/css/navstyle.css" %>
<%@ include file="/frontend/css/navlogin.css" %>
</style>


<nav class="navbar navbar-default">
    <div class="container-fluid">

        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">ethelon</a>
        </div>


        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ποιοι είμαστε <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Η οργάνωση</a></li>
                        <li><a href="#">Η ομάδα</a></li>
                        <li><a href="#">Κοινωνικός αντίκτυπος</a></li>

                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Εθελοντές <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Εθελοντικές θέσεις σε ΜΚΟ</a></li>
                        <li><a href="#">Events και κοινωνικές δράσεις</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">ΜΚΟ <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Εγγεγραμμένοι Οργανισμοί</a></li>
                        <li><a href="#">Κοινωνικές δράσεις</a></li>
                        <li><a href="#">Εκπαιδευτικά Σεμινάρια</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Εταιρίες <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Δημιουργία προγράμματος εθελοντισμού</a></li>
                        <li><a href="#">Εθελοντικές δράσεις</a></li>
                    </ul>
                </li>
                <li><a href="#">Blog</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#login-modal">Σύνδεση</a>
                    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
                        <div class="modal-dialog">
                            <div class="loginmodal-container">
                                <h1>Σύνδεση</h1><br>
                                <form>
                                    <input type="text" name="username" placeholder="Όνομα χρήστη">
                                    <input type="password" name="password" placeholder="Κώδικος">
                                    <input type="submit" name="login" class="login loginmodal-submit" value="Σύνδεση">
                                </form>

                                <div class="login-help">
                                    <a href="create_account.xhtml">Εγγραφή</a> - <a href="#">Ξέχασα τον κωδικό</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="profile_vol.jsp" target="_blank"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span> Το προφίλ μου</a></li>
                        <li><a href="/logout"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span> Έξοδος</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>

