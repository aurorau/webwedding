<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
<%-- 	<meta name="_csrf" content="${_csrf.token}"/>
	<!-- default header name is X-CSRF-TOKEN -->
	<meta name="_csrf_header" content="${_csrf.headerName}"/> --%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>W2-WebWedding</title>

    <!-- Material Design fonts -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:300,400,500,700" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/agency.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="css/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Lobster+Two' rel='stylesheet' type='text/css'>
    <link href='css/common-style.css' rel='stylesheet' type='text/css'>
    
    <link rel="shortcut icon" href="img/shortcut.png">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    </style>
</head>

<body id="page-top" class="index">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <!-- <a class="navbar-brand page-scroll" href="#page-top">Start Bootstrap</a> -->
                
				<div class="budget-topbar pull-right">
					<a href="#" class="dropdown-toggle nav-cart" data-toggle="dropdown" role="button" aria-haspopup="true" onclick="displayBudget()">
						<span class="fa fa-calculator fa-2x"></span>
							<label class="badge cart-value" ></label>
					</a>
				<ul class="dropdown-menu show-budget">
				   <table class="table table-responsive">
				      <thead>
				          <tr>
				              <th>Selected Categories</th>
				              <th>Budget Rs.</th>
				          </tr>
				      </thead>
				       <tbody class="budgetTableId">
				       </tbody>
				   </table>
				 </ul>
				 </div>
                
                 <a class="page-scroll btn btn-ad-top pull-right margin-right20" href="#post-ad">Register</a>
                
                <a class="navbar-brand page-scroll brand" href="#page-top">webwedding.lk</a>
                <br>
                
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse change-color" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle page-scroll change-link" data-toggle="dropdown" role="button" aria-haspopup="true">Services<span class="caret"></span></a>
                        <ul class="dropdown-menu" id="categoryMainDropDown">
                         </ul>
                    </li>
                    
                     <li>
                       <a class="page-scroll" href="#gallery">Gallery</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#article">Articles</a>
                    </li>
                    <li>
                        <a class="page-scroll btn btn-ad margin-left5" href="#post-ad">Register</a>
                    </li>
                    <li>
                       <div class="budget">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" class="nav-cart" onclick="displayBudget()">
                        	<span class="fa fa-calculator fa-2x"></span>
                        		<label class="badge cart-value"></label>
                        </a>
                        
                        <ul class="dropdown-menu show-budget">
                           <table class="table table-responsive">
                              <thead>
                                  <tr>
                                      <th>Selected Categories</th>
                                      <th>Budget Rs.</th>
                                  </tr>
                              </thead>
                               <tbody class="budgetTableId">
                               </tbody>
                           </table>
                         </ul>
                         </div>
                     </li>
<!--                      <li class="translate">  
                         <span id="translate-sinhala" role="button">SI</span>
                         <span id="translate-english" role="button">EN</span>
                      </li>  -->     
                </ul>
                
                
                
                
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Header -->
    <header>
        <div class="intro-text">
           
            <div class="intro-header col-lg-6">
<!--                <div class="intro-lead-in">Welcome to webwedding.lk</div>-->
                <div class="intro-heading">Sri Lanka's largest Wedding Directory</div>
                <div class="intro-subheading">
                 we are dedicated to provide all type of wedding services such as Hall-details, Dress-selections, photography, dancing groups, decorations etc.. within few seconds while drastically reducing your travelling cost and more importantly your precious time.
                 At the same time, for entrepreneurs, we provide a great opportunity to extend your business by registering it in our site hence your business will even be exposed to overseas and people who work in overseas and planning their dream-day to be here, will definitely get attached with your business too.
                </div>

                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-12 intro-category">
                    <table class="table table-responsive" id="category">
                        <thead>
                            <tr>
                                <th colspan=3>Browse Our Services</th>
                            </tr>
                        </thead>
                        <tbody id="serviceCategoryDynamicTableW2">
                        </tbody>
                    </table>
                </div>
          </div>
          <img src="img/header-img.jpg" alt="header-image" class="img-responsive">
        </div>



    </header>
   
       <!--About us-->
    <section id="aboutus">
        <div class="container">
            <div class="col-lg-6">
                <!--                <div class="intro-lead-in">Welcome to webwedding.lk</div>-->
                <h3>Sri Lanka's largest Wedding Directory</h3>
                <div class="">
                 we are dedicated to provide all type of wedding services such as Hall-details, Dress-selections, photography, dancing groups, decorations etc.. within few seconds while drastically reducing your travelling cost and more importantly your precious time.
                 At the same time, for entrepreneurs, we provide a great opportunity to extend your business by registering it in our site hence your business will even be exposed to overseas and people who work in overseas and planning their dream-day to be here, will definitely get attached with your business too.                
                </div>

                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-12">
                    <table class="table table-responsive" id="category">
                        <thead>
                            <tr>
                                <th colspan=3>Browse Our Services</th>
                            </tr>
                        </thead>
                        <tbody id="serviceCategoryDynamicTableW2Phone">

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
   
    <!-- Services Section -->
    <section id="portfolio" class="bg-light-gray">
        <div class="container">

            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3 class="section-heading">Services</h3>
                </div>
            </div>
            <div class="col-xs-12 col-md-10 filter">
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                    <label>Select a Service</label>
                    <select class="form-control" id="serviceCategoryDD" >
                        <option value="">Select a Service</option>
                    </select>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                    <label>Select a City</label>
                    <select class="form-control" id="districtDD">
                        <option value="">Select a City</option>
                    </select>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                   <label>Expected Budget Rs.</label>
                    <input class="form-control" type="text" id="budgetId" onKeyPress="return checkedInputTypeNumberic(this, event)"/>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                    <button type="button" class="btn btn-primary margin-top24" onclick="loadCompanyDetailsTableW2()"><span class="fa fa-search"></span>Search</button>
                </div>

            </div>
            <div class="clearfix"></div>
            <div class="col-md-10 col-sm-12 category-box">
            <div class="col-lg-10 col-lg-offset-1 scrollxonly margin-bottom10">
	           <div id="dynamicCompanyTableW2">
<!-- 	          		<tbody id="dynamicCompanyTableW2">
	          		
	          		</tbody> -->
	           </div>
            </div>
            <div class="clearfix"></div>
            </div>
            <div class="col-md-2 col-sm-12 padding-right0" id="ads">

            </div>
        </div>
    </section>

    <!-- About Section -->
    <section id="gallery">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3 class="section-heading">Gallery</h3>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12" id="imageCategoryTableW2">

                </div>
            </div>

        </div>
    </section>

    <!-- Article Section -->
    <section id="article" class="bg-light-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3 class="section-heading">Articles</h3>
                </div>
            </div>
            <div class="row">
            	<div class="col-xs-12">
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
	                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
	                            <h4 class="panel-title">Article 1</h4>
	                        </a>
                        </div>
                        <div id="collapse1" class="panel-collapse collapse in">
                            <div class="panel-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	<a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                            	<h4 class="panel-title">Article 2</h4>
                        	</a>
                        </div>
                        <div id="collapse2" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                        </div>
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                        	<a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                            	<h4 class="panel-title">Article 3</h4>
                            </a>
                        </div>
                        <div id="collapse3" class="panel-collapse collapse">
                            <div class="panel-body">
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
                            </div>
                        </div>
                    </div>
                </div>
            	</div>
            </div>
        </div>
    </section>
    
    <!-- Post your ad Section -->
    
     <section id="post-ad" class="bg-gray">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                   <h3 class="section-heading">Expand your Business with us.</h3>
<!--                    <h4 class="section-subheading text-muted">Expand your Business with us.</h4>-->
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                   <!--  <form name="sentMessage" id="contactForm" novalidate> -->
                        <div class="row">
<!--
                            <div class="col-xs-12 margin-top10 margin-bottom10">
                                <span class="web-info">We are offering 100% free discount for all our registerd Wedding Suppliers from Jan 2016 to 31st March 2016.Register NOW and be a part of our Loyalty Customer.</span>
                            </div>
-->

                            <div class="col-md-8 col-md-offset-2">
                                <div class="panel">
                                    <div class="panel-heading">
                                        <ul class="nav nav-tabs">
                                            <li class="active"><a href="#tab1" data-toggle="tab">Sell My Product/Service</a></li>
                                            <li><a href="#tab2" data-toggle="tab">Publish My Advertisement</a></li>
                                        </ul>
                                    </div>
                                    <div class="panel-body tab-content">
                                        <!--START TAB 1-->
                                        <div class="tab-pane active" id="tab1">
                                            <div class="col-xs-12 form-group">
                                                <input type="text" class="form-control" placeholder="First Name *" id="firstNameInPS" required data-validation-required-message="Please enter your first name." onkeyup="hideValidation('firstNameValidationInPs')" onkeydown="limitedLength('firstNameInPS',98)">
                                                <span class="help-block text-danger" id="firstNameValidationInPs"></span>
                                            </div>
                                            <div class="col-xs-12 form-group">
                                                <input type="text" class="form-control" placeholder="Last Name *" id="lastNameInPS" required data-validation-required-message="Please enter your last name." onkeyup="hideValidation('lastNameValidationInPs')" onkeydown="limitedLength('lastNameInPS',98)">
                                                <span class="help-block text-danger" id="lastNameValidationInPs"></span>
                                            </div>   
                                            <div class="col-xs-12 col-md-6 form-group">
                                                <input type="tel" class="form-control" placeholder="Contact No. *" id="phoneInPS" required data-validation-required-message="Please enter your phone number." onkeyup="hideValidation('phoneValidationInPs')" onKeyPress="return checkedInputTypeNumberic(this, event)" onkeydown="limitedLength('phoneInPS',12)">
                                                <span class="help-block text-danger" id="phoneValidationInPs"></span>
                                            </div>
                                            <div class="col-xs-12 col-md-6 form-group">
                                                <input type="text" class="form-control" placeholder="Email Address *" id="emailInPS" required data-validation-required-message="Please enter your email address" onkeyup="hideValidation('emailValidationInPs')" onkeydown="limitedLength('emailInPS',98)">
                                                <span class="help-block text-danger" id="emailValidationInPs"></span>
                                            </div>
                                            <div class="col-xs-12 form-group">
	                                            <textarea class="form-control" placeholder="Company Address" id="addressInPS" onkeydown="limitedLength('addressInPS',325)"></textarea>
	                                            <span class="help-block text-danger"></span>
                                            </div>
                                            <div class="col-xs-12 form-group">
	                                            <textarea class="form-control" placeholder="Your Message" id="messageInPS" onkeydown="limitedLength('messageInPS',425)"></textarea>
	                                            <span class="help-block text-danger"></span>
                                            </div>
                                            <div class="col-xs-12">
                                                <span class="label danger submit-label pull-right" id="unsuccess"><span class="fa fa-close"> </span>Form is not sumbitted properly.</span>
                                                <span class="label success submit-label pull-right" id="success"><span class="fa fa-thumbs-o-up margin-right3"></span>Form is sumbitted properly.</span>
                                            </div>
                                            <div class="col-xs-12 form-group">
                                                <button class="btn btn-primary pull-right" onclick="saveSupplierDetailsW2()">Send Message</button>
                                            </div>
                                        </div>
                                         <!--END TAB 1--> 
                                        <!--START TAB 2-->
                                        <div class="tab-pane" id="tab2">                                           
                                            <div class="col-xs-12 form-group">
                                                <input type="text" class="form-control" placeholder="Full Name *" id="nameInAdd" required data-validation-required-message="Please enter your name." onkeyup="hideValidation('nameValidationInAdd')" onkeydown="limitedLength('nameInAdd',148)">
                                                <span class="help-block text-danger" id="nameValidationInAdd"></span>
                                            </div>
                                            <div class="col-xs-12 col-md-6 form-group">
                                                <input type="tel" class="form-control" placeholder="Contact No. *" id="phoneInAdd" required data-validation-required-message="Please enter your phone number." onkeyup="hideValidation('phoneValidationInAdd')" onKeyPress="return checkedInputTypeNumberic(this, event)" onkeydown="limitedLength('phoneInAdd',12)">
                                                <span class="help-block text-danger" id="phoneValidationInAdd"></span>
                                            </div>
                                            <div class="col-xs-12 col-md-6 form-group">
                                                <input type="text" class="form-control" placeholder="Email Address *" id="emailInAdd" required data-validation-required-message="Please enter your email address" onkeyup="hideValidation('emailValidationInAdd')">
                                                <span class="help-block text-danger" id="emailValidationInAdd"></span>
                                            </div>
                                            <div class="col-xs-12 form-group">
                                                <textarea class="form-control" placeholder="Add Description " id="descriptionInAdd" onkeydown="limitedLength('descriptionInAdd',425)"></textarea>
                                            </div>
                                            <div class="col-xs-12">
                                                <span class="label danger submit-label pull-right" id="unsuccessInAdd"><span class="fa fa-close"> </span>Form is not sumbitted properly.</span>
                                                <span class="label success submit-label pull-right" id="successInAdd"><span class="fa fa-thumbs-o-up margin-right3"></span>Form is sumbitted properly.</span>
                                            </div>
                                            <div class="col-xs-12 form-group">
                                                <button type="submit" class="btn btn-primary pull-right" onclick="saveAddDetailsW2()">Submit</button>
                                            </div>
                                        </div>                                      
                                        <!--END TAB 2-->
                                    </div>
                                </div>
                            </div>
                        </div>
                    <!-- </form> -->
                </div>
            </div>
        </div>
    </section>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-4">
                    <span class="copyright">Copyright &copy; www.webwedding.lk 2016</span>
                </div>
                <div class="col-md-4">
                    <ul class="list-inline quicklinks">
                        <li><a href="#page-top">Home</a></li>
                        <li><a href="#portfolio">Services</a></li>
                        <li><a href="#gallery">Gallery</a></li>
                        <li><a href="#article">Articles</a></li>
                        <li><a href="#post-ad">Register</a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <span class="logo">webwedding.lk</span>
                </div>
            </div>
        </div>
    </footer>

    <div class="portfolio-modal modal fade" id="service1" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="modal-body">
                        <h2><span id="comapnyNameW2"></span></h2>
                        <div class="col-lg-12">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">

                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
<!--                                     <li data-target="#myCarousel" data-slide-to="2"></li>
                                    <li data-target="#myCarousel" data-slide-to="3"></li> -->
                                </ol>


                                <div class="carousel-inner product-images" role="listbox" id="companyProfileImageGallery">
                                   <div class="item active" id="itemActiveDiv">
                                   </div>
                                </div>
                                <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div>
                            <p id="companyDescription">
                            <!-- Awarded the title of Sri Lanka’s Leading Hotel and Sri Lanka’s Leading Business Hotel at the World Travel Awards, this Colombo hotel is centrally located in Colombo’s business district. With a range of accommodation, from guest rooms and executive rooms to suites, this hotel in Colombo offers stunning views over the Indian Ocean. For relaxation and business alike, Guests will enjoy the endless luxurious accommodations we have to offer. -->
                            </p>
                        </div>
                        <div class="col-xs-12 packages">
                        <div class="col-lg-12 margin-top40">
                            <div class="col-sm-2 col-lg-2 text-left">
                                <label class="control-label info">Min Price</label>
                            </div>
                            <div class="col-sm-10 col-lg-10 text-left">
                            	<label class="label label-warning offers">
	                                <span>Rs.</span>
	                                <span id="priceW2"></span>
	                                <span>*</span>
                                </label>
                                <span>&nbsp;(Negotiable)</span>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 margin-top10" >
                             <div class="col-xs-12 col-sm-2 col-lg-2 text-left" >
                                <label class="control-label info">Packages</label>
                            </div>
                            <div class="col-xs-12 col-sm-10 col-lg-10 text-left">
                            	<table id="packageDetailsDivId">
                            	</table>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-lg-12 margin-top10 margin-bottom40">
                            <div class="col-xs-12 col-sm-2 col-lg-2 text-left">
                                <label class="control-label info">Special Offers</label>
                            </div>
<!--                             <div class="col-xs-12 col-sm-10 col-lg-10 text-left">
                                <label class="control-label" id="sp1">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</label>
                            </div> -->
                            <div class="col-xs-12 col-sm-10 col-lg-10 text-left">
                            	<table id="offerDetailsTableId">
                            	</table>
                            </div>
                        </div>  
                        </div> 
                        <div class="clearfix"></div>
                        <div class="col-xs-12 col-md-6 contact-details">
                            <div class="col-xs-12">
                                <h4 class="text-center">
                                <!-- <span>Mr.</span> -->
                                <span id="companyOwnerW2"></span> </h4>
                               <!--  <p class="text-center">Sales Manager</p> -->
                                <p class="text-center" id="companyAddW2"></p>
                            </div>
                            <div class="col-xs-12 col-sm-6 padding10">
                                <span class="fa fa-phone" id="companyTpW2"></span>
                            </div>
                            <div class="col-xs-12 col-sm-6 padding10">
                                <span class="fa fa-envelope"></span><a href="mailto:hilton@gmail.com"><span id="companyEmailW2"></span></a>
                            </div>
<!--                             <div class="col-xs-12 col-sm-6">
                                <span class="fa fa-sitemap"></span>Kandy,Trincomalee
                            </div> -->
                            <div class="col-xs-12 col-sm-6 padding10">
                                <span class="fa fa-globe"></span><a href="hilton.com" target="_blank"><span id="companyWebW2"></span></a>
                            </div>
<!--                             <div class="col-xs-12 col-sm-6">
                                <span class="fa fa-skype"></span><span id="companySkypW2"></span>
                            </div> -->
                            <div class="col-xs-12 col-sm-6 padding10">
                                <span class="fa fa-facebook"></span><a href="https://www.facebook.com/hilton/" target="_blank"><span id="companyFbW2"></span></a>
                            </div>

                        </div>   
                        <div class="col-md-6 padding-none">
                            <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?hl=en&q=Colombo 1, SRI LANKA&ie=UTF8&t=roadmap&z=16&iwloc=B&output=embed">
                           <!--  ?hl=en&q=hilton hotel 2 SIR CHITTAMPALAM A GARDINER MW, COLOMBO 2, 02, SRI LANKA&ie=UTF8&t=roadmap&z=16&iwloc=B&output=embed" -->
                                <div><small><a href="http://embedgooglemaps.com">embedgooglemaps.com</a></small>
                                </div>
                                <div><small><a href="https://ultimatewebtraffic.com/">buy websit traffic Ultimatewebtraffic</a></small>
                                </div>
                            </iframe>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="CaterorGallery" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-content">
            <div class="close-modal" data-dismiss="modal">
                <div class="lr">
                    <div class="rl">
                    </div>
                </div>
            </div>
            <div class="container">
                <div class="row">
                    <div class="modal-body" id="imageCategoryGalleryDivW2">
<!--                         <img src="img/gallery/sinhala/sinhala1.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala2.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala3.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <img src="img/gallery/sinhala/sinhala4.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala5.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala6.jpg" class="gallery" alt=""> -->
                        
                    </div>
                    <div class="clearfix"></div>
                    <div class="col-xs-12 margin-top20">
                    	<button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                    </div>

                </div>
            </div>
        </div>
    </div>


    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <!--    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>-->
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/agency.js"></script>
    <script src="js/site.js"></script>
    <script src="js/moment.min.js"></script>
    <script src="js/webwedding.js"></script>
    <script src="js/jquery.displaytag-ajax-1.2.js"></script>
	<script src="js/common.js"></script>
	<script src="https://code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
    <script src="js/rtiNew5.js"></script>
    <script>
    </script>

<!-- <script>
  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');

  ga('create', 'UA-74142281-1', 'auto');
  ga('send', 'pageview');

</script> -->

</body>

</html>
