<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

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
    <link href='css/common-style.css' rel='stylesheet' type='text/css'>

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
                <a class="navbar-brand page-scroll" href="#page-top">Start Bootstrap</a></br>
                
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle page-scroll" data-toggle="dropdown" role="button" aria-haspopup="true">Services <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#portfolio">Wedding Attire</a></li>
                            <li><a href="#portfolio">Wedding Dress Designers</a></li>
                            <li><a href="#portfolio">Beautician</a></li>
                            <li><a href="#portfolio">Jewelary</a></li>
                            <li><a href="#portfolio">Cultural Requirement</a></li>
                            <li><a href="#portfolio">Photography</a></li>
                            <li><a href="#portfolio">Wedding Planning</a></li>
                            <li><a href="#portfolio">Wedding Venues</a></li>
                            <li><a href="#portfolio">Food</a></li>
                            <li><a href="#portfolio">Invitation Cards</a></li>
                            <li><a href="#portfolio">Cake Boxes</a></li>
                            <li><a href="#portfolio">Transport</a></li>
                         </ul>
                    </li>
                    
                     <li>
                       <a class="page-scroll" href="#gallery">Gallery</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#article">Articles</a>
                    </li>
                    <li>
                        <a class="page-scroll btn btn-ad margin-left5" href="#post-ad">Post your ad</a>
                    </li>
                    <li>
                       <div class="budget">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" id="nav-cart" ><span class="fa fa-shopping-cart fa-2x"></span><label class="badge" id="cart-value">3</label></a>
                        
                        <ul class="dropdown-menu show-budget">
                           <table class="table table-responsive">
                              <thead>
                                  <tr>
                                      <th>Selected Categories</th>
                                      <th>Budget Rs.</th>
                                  </tr>
                              </thead>
                               <tbody>
                                   <tr>
                                       <td>Hilton</td>
                                       <td>300000</td>
                                    </tr>
                                    <tr>
                                       <td>Lassana Flora</td>
                                       <td>100000</td>
                                    </tr>
                                    <tr>
                                       <td>Studio 3000</td>
                                       <td>100000</td>
                                   </tr>
                                    <tr>
                                       <td>Total Budget</td>
                                       <td id="total">500000</td>
                                   </tr>
                               </tbody>
                           </table>
                         </ul>
                         </div>
                     </li>
                     <li class="translate">  
                         <span id="translate-sinhala" role="button">SI</span>
                         <span id="translate-english" role="button">EN</span>
                      </li>      
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
                <div class="intro-subheading">You can choose your own Wedding Suppliers from our free directory and make your BIG DREAM comes true.</div>

                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-12 intro-category">
                    <table class="table table-responsive" id="category">
                        <thead>
                            <tr>
                                <th colspan=3>Browse Our Categories</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="#portfolio">Wedding Attire</a>
                                </td>
                                <td><a href="#portfolio">Dress Designers</a>
                                </td>
                                <td><a href="#portfolio">Beauticians</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Jewelary</a>
                                </td>
                                <td><a href="#portfolio">Cultural Requirement</a>
                                </td>
                                <td><a href="#portfolio">Photography</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Wedding Planning</a>
                                </td>
                                <td><a href="#portfolio">Wedding Venues</a>
                                </td>
                                <td><a href="#portfolio">Food</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Invitation Cards</a>
                                </td>
                                <td><a href="#portfolio">Cake Boxes</a>
                                </td>
                                <td><a href="#portfolio">Transport</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Floral</a>
                                </td>
                                <td><a href="#portfolio">Dowry</a>
                                </td>
                                <td><a href="#portfolio">Honeymoon</a>
                                </td>
                            </tr>
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
                <div class="">You can choose your own Wedding Suppliers from our free directory and make your BIG DREAM comes true.</div>

                <div class="col-xs-12 col-sm-12 col-md-8 col-lg-12">
                    <table class="table table-responsive" id="category">
                        <thead>
                            <tr>
                                <th colspan=3>Browse Our Categories</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><a href="#portfolio">Wedding Attire</a>
                                </td>
                                <td><a href="#portfolio">Dress Designers</a>
                                </td>
                                <td><a href="#portfolio">Beauticians</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Jewelary</a>
                                </td>
                                <td><a href="#portfolio">Cultural Requirement</a>
                                </td>
                                <td><a href="#portfolio">Photography</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Wedding Planning</a>
                                </td>
                                <td><a href="#portfolio">Wedding Venues</a>
                                </td>
                                <td><a href="#portfolio">Food</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Invitation Cards</a>
                                </td>
                                <td><a href="#portfolio">Cake Boxes</a>
                                </td>
                                <td><a href="#portfolio">Transport</a>
                                </td>
                            </tr>
                            <tr>
                                <td><a href="#portfolio">Floral</a>
                                </td>
                                <td><a href="#portfolio">Dowry</a>
                                </td>
                                <td><a href="#portfolio">Honeymoon</a>
                                </td>
                            </tr>
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
                        <option>Wedding Attire</option>
                        <option>Wedding Dress Designers</option>
                        <option>Beautician</option>
                    </select>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                    <label>Select a District</label>
                    <select class="form-control" >
                        <option>Colombo</option>
                        <option>Gampaha</option>
                        <option>Kalutara</option>
                    </select>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                   <label>Expected Budget Rs.</label>
                    <input class="form-control"/>
                </div>
                <div class="col-xs-12 col-sm-6 col-md-3 margin-bottom10">
                    <button type="button" class="btn btn-success margin-top20"><span class="fa fa-search"></span>Search</button>
                </div>

            </div>
            <div class="clearfix"></div>
            <div class="col-md-10 col-sm-12 category-box">
                <div class="clearfix"></div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#service1" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/hilton.png" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                    <span>100,000 upwards</span>
                        <a href="#portfolio" id="add-to-cart1" class="add-to-cart" data-toggle="tooltip" title="Add to Cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal2" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/taj.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" id="" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal3" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/cinnamon.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" id="" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/citrus.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" id="" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/Galle-Face.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" id="" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/imperial-hotel.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" id="" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/kingsburry.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="col-lg-3 col-sm-4 col-xs-6 portfolio-item">
                    <a href="#portfolioModal4" class="portfolio-link" data-toggle="modal">
                        <div class="portfolio-hover">
                            <div class="portfolio-hover-content">
                                <i class="fa fa-plus fa-3x"></i>
                            </div>
                        </div>
                        <img src="img/portfolio/royal.jpg" class="img-responsive" alt="" width="300">
                    </a>
                    <div class="portfolio-caption">
                        <span>100,000 upwards</span>
                        <a href="#portfolio" id="" class="add-to-cart"><span class="fa fa-shopping-cart fa-2x"></span></a>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="col-lg-12 portfolio-item">
                    <nav class="">
                        <ul class="pagination">
                            <li>
                                <a href="#" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <li><a href="#">1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li><a href="#">4</a>
                            </li>
                            <li><a href="#">5</a>
                            </li>
                            <li>
                                <a href="#" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
            <div class="col-md-2 col-sm-12 padding-right0" id="ads">
                <div class="ads">
                    <a href="#portfolioModal5" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/hotel-ad1.jpg" class="img-responsive" alt="" width="300">
                    </a>
                </div>

                <div class="ads">
                    <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/hotel-ad2.jpg" class="img-responsive" alt="" width="300">
                    </a>
                </div>

                <div class="ads">
                    <a href="#portfolioModal6" class="portfolio-link" data-toggle="modal">
                        <img src="img/portfolio/hotel-ad3.jpg" class="img-responsive" alt="" width="300">
                    </a>
                </div>
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
                <div class="col-lg-12">
                    <div class="portfolio-item">
                        <a href="#gallery-sinhala" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Sinhala Wedding Culture</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/sinhala-culture.jpg" alt="sinhala-wedding" class="gallery">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-tamil" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Hindu Wedding Culture</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/hindu-culture.jpg" class="gallery" alt="hindu-wedding">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-muslim" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Muslim Wedding Culture</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/muslim-culture.jpg" class="gallery" alt="muslim-wedding">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-bouquet" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Bridal Flower Bouquets</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/bouquet.jpg" class="gallery" alt="bouquet">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-poruwa" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Sinhala Wedding Poru</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/poruwa.jpg" class="gallery" alt="poruwa">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-cake" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Wedding Cake Structures</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/cake.jpg" class="gallery" alt="wedding-cake">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-hair" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Bridal Hair Designs</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/hair-style.jpg" class="gallery" alt="bridal-hair-dress">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-card" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Wedding Invitation cards</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/invitation-card.jpg" class="gallery" alt="invitation-cards">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-cakebox" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Wedding Cake Boxes</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/cake-box.jpg" class="gallery" alt="wedding-cake-box">
                        </a>
                    </div>
                    <div class="portfolio-item">
                        <a href="#gallery-mehendi" class="portfolio-link" data-toggle="modal">
                            <div class="portfolio-hover">
                                <div class="portfolio-hover-content">
                                    <h4>Hindu Bridal Mehendi Designs</h4>
                                </div>
                            </div>
                            <img src="img/gallery/profile/mehendi.jpg" class="gallery" alt="mehendi">
                        </a>
                    </div>
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
                <div class="panel-group" id="accordion">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                Article 1</a>
                            </h4>
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
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">
                    Article 2</a>
                            </h4>
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
                            <h4 class="panel-title">
                                <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">
                    Article 3</a>
                            </h4>
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
    </section>
    
    <!-- Post your ad Section -->
    <section id="post-ad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <h3 class="section-heading">Supplier Registration Form</h3>
                    <h5 class="section-subheading text-muted"><i>Please fill this form if you wish to expand your business through our site</i></h5>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <form name="sentMessage" id="contactForm" novalidate>
                        <div class="row">
                           <div class="col-xs-12 margin-top10 margin-bottom10">
                                <span class="web-info">We are offering 100% free discount for all our registerd Wedding Suppliers from Jan 2016 to 31st March 2016.Register NOW and be a part of our Loyalty Customer.</span>
                            </div>
                          
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="text" class="form-control" placeholder="Your Name *" id="name" required data-validation-required-message="Please enter your name.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <select class="form-control" id="category-type" required data-validation-required-message="Please select your category.">
                                        <option>Your Category *</option>
                                        <option>dfd</option>
                                        <option>dfd</option>
                                        <option>df</option>
                                    </select>
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="text" class="form-control" placeholder="Your Company Name *" id="email" required data-validation-required-message="Please enter your email address.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="email" class="form-control" placeholder="Your Company Address *" id="address" required data-validation-required-message="Please enter your Company Address.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="text" class="form-control" placeholder="Cities of Branches (if you have any)" id="branches" >
                                    <p class="help-block text-danger"></p>
                                </div>
                                
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="tel" class="form-control" placeholder="Your Contact No. *" id="phone" required data-validation-required-message="Please enter your phone number.">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="text" class="form-control" placeholder="Your Email Address *" id="email" required data-validation-required-message="Please enter your email address">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <input type="text" class="form-control" placeholder="Your Skype No." id="skype">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                   <input type="text" class="form-control"  placeholder="Your Official Company Web Site URL (if you have any)" id="url">
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 col-sm-6 form-group">
                                    <textarea class="form-control" placeholder="Your Message *" id="message" required data-validation-required-message="Please enter a message."></textarea>
                                    <p class="help-block text-danger"></p>
                                </div>
                                <div class="col-xs-12 form-group">
                                    <div id="success"></div>
                                    <button type="submit" class="btn btn-success pull-right">Send Message</button>
                                </div>
                         
                            
                            
                           
                        </div>
                    </form>
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
                        <li><a href="#post-ad">Post your ad</a></li>
                    </ul>
                </div>
                <div class="col-md-4">
                    <Span>Place logo here</span>
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
                        <h2>Hilton Colombo</h2>
                        <div class="col-lg-12">
                            <div id="myCarousel" class="carousel slide" data-ride="carousel">

                                <ol class="carousel-indicators">
                                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                                    <li data-target="#myCarousel" data-slide-to="1"></li>
                                    <li data-target="#myCarousel" data-slide-to="2"></li>
                                    <li data-target="#myCarousel" data-slide-to="3"></li>
                                </ol>


                                <div class="carousel-inner product-images" role="listbox">
                                    <div class="item active">
                                        <img src="img/portfolio/hotel1.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="img/portfolio/hotel2.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img src="img/portfolio/hotel3.jpg" alt="">
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
                            <p>Awarded the title of Sri Lanka’s Leading Hotel and Sri Lanka’s Leading Business Hotel at the World Travel Awards, this Colombo hotel is centrally located in Colombo’s business district. With a range of accommodation, from guest rooms and executive rooms to suites, this hotel in Colombo offers stunning views over the Indian Ocean. For relaxation and business alike, Guests will enjoy the endless luxurious accommodations we have to offer.</p>
                        </div>
                        <div class="col-lg-12">
                            <span class="price-tag label">Rs. 20,000.00 upward</span>
                            <div class="clearfix"></div>
                            <span class="pull-left">Negotiable</span>
                        </div>
                        <div class="clearfix"></div>
                        <div class="col-md-6">
                            <div class=" contact-details">
                                <span class="fa fa-user"></span>Mr. John Smith
                                <div class="clearfix"></div>
                                <span class="fa fa-map-marker"></span>2, Sir Chiiampalam A Gardiner Mw, Colombo 2, Sri Lanka.
                                <div class="clearfix"></div>
                                <span class="fa fa-sitemap"></span>No Branches
                                <div class="clearfix"></div>
                                <span class="fa fa-phone"></span>+94-11-249-2492
                                <div class="clearfix"></div>
                                <span class="fa fa-envelope"></span><a href="mailto:hilton@gmail.com">hilton@gmail.com</a>
                                <div class="clearfix"></div>
                                <span class="fa fa-facebook"></span><a href="https://www.facebook.com/hilton/" target="_blank">https://www.facebook.com/hilton</a>
                                <div class="clearfix"></div>
                                <span class="fa fa-skype"></span>call.hiton
                                <div class="clearfix"></div>
                                <span class="fa fa-globe"></span><a href="hilton.com" target="_blank">hilton.com</a>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <iframe frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://maps.google.com/maps?hl=en&q=hilton hotel 2 SIR CHITTAMPALAM A GARDINER MW, COLOMBO 2, 02, SRI LANKA&ie=UTF8&t=roadmap&z=16&iwloc=B&output=embed">
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

    <div class="portfolio-modal modal fade" id="gallery-sinhala" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/sinhala/sinhala1.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala2.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala3.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <img src="img/gallery/sinhala/sinhala4.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala5.jpg" class="gallery" alt="">
                        <img src="img/gallery/sinhala/sinhala6.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>


                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-tamil" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/hindu/hindu5.jpg" class="gallery" alt="">
                        <img src="img/gallery/hindu/hindu3.jpg" class="gallery" alt="">
                        <img src="img/gallery/hindu/hindu4.jpg" class="gallery" alt="">
                        <img src="img/gallery/hindu/hindu1.jpg" class="gallery" alt="">
                        <img src="img/gallery/hindu/hindu6.jpg" class="gallery" alt="">
                        <img src="img/gallery/hindu/hindu7.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>


                    </div>

                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-muslim" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/muslim/muslim1.jpg" class="gallery" alt="">
                        <img src="img/gallery/muslim/muslim2.jpg" class="gallery" alt="">
                        <img src="img/gallery/muslim/muslim3.jpg" class="gallery" alt="">
                        <img src="img/gallery/muslim/muslim4.jpg" class="gallery" alt="">
                        <img src="img/gallery/muslim/muslim5.jpg" class="gallery" alt="">
                        <img src="img/gallery/muslim/muslim6.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-bouquet" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/bouquet/flower1.jpg" class="gallery" alt="">
                        <img src="img/gallery/bouquet/flower2.jpg" class="gallery" alt="">
                        <img src="img/gallery/bouquet/flower3.jpg" class="gallery" alt="">
                        <img src="img/gallery/bouquet/flower4.jpg" class="gallery" alt="">
                        <img src="img/gallery/bouquet/flower5.jpg" class="gallery" alt="">
                        <img src="img/gallery/bouquet/flower6.jpg" class="gallery" alt="">

                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-poruwa" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/poru/poru1.jpg" class="gallery" alt="">
                        <img src="img/gallery/poru/poru2.jpg" class="gallery" alt="">
                        <img src="img/gallery/poru/poru3.jpg" class="gallery" alt="">
                        <img src="img/gallery/poru/poru4.jpg" class="gallery" alt="">
                        <img src="img/gallery/poru/poru5.jpg" class="gallery" alt="">
                        <img src="img/gallery/poru/poru6.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-cake" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/cake/cake1.jpg" class="gallery" alt="">
                        <img src="img/gallery/cake/cake2.jpg" class="gallery" alt="">
                        <img src="img/gallery/cake/cake3.jpg" class="gallery" alt="">
                        <img src="img/gallery/cake/cake4.jpg" class="gallery" alt="">
                        <img src="img/gallery/cake/cake5.jpg" class="gallery" alt="">
                        <img src="img/gallery/cake/cake6.jpg" class="gallery" alt="">

                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-hair" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/hair-style/hair1.jpg" class="gallery" alt="">
                        <img src="img/gallery/hair-style/hair2.jpg" class="gallery" alt="">
                        <img src="img/gallery/hair-style/hair3.jpg" class="gallery" alt="">
                        <img src="img/gallery/hair-style/hair4.jpg" class="gallery" alt="">
                        <img src="img/gallery/hair-style/hair5.jpg" class="gallery" alt="">
                        <img src="img/gallery/hair-style/hair6.jpg" class="gallery" alt="">

                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-card" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/cards/cards1.jpg" class="gallery" alt="">
                        <img src="img/gallery/cards/cards2.jpg" class="gallery" alt="">
                        <img src="img/gallery/cards/cards3.jpg" class="gallery" alt="">
                        <img src="img/gallery/cards/cards4.jpg" class="gallery" alt="">
                        <img src="img/gallery/cards/cards5.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-cakebox" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/box/box1.jpg" class="gallery" alt="">
                        <img src="img/gallery/box/box2.jpg" class="gallery" alt="">
                        <img src="img/gallery/box/box3.jpg" class="gallery" alt="">
                        <img src="img/gallery/box/box4.jpg" class="gallery" alt="">
                        <img src="img/gallery/box/box5.jpg" class="gallery" alt="">
                        <img src="img/gallery/box/box6.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="portfolio-modal modal fade" id="gallery-mehendi" tabindex="-1" role="dialog" aria-hidden="true">
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
                        <img src="img/gallery/mehendi/mehendi1.jpg" class="gallery" alt="">
                        <img src="img/gallery/mehendi/mehendi2.jpg" class="gallery" alt="">
                        <img src="img/gallery/mehendi/mehendi3.jpg" class="gallery" alt="">
                        <img src="img/gallery/mehendi/mehendi4.jpg" class="gallery" alt="">
                        <img src="img/gallery/mehendi/mehendi5.jpg" class="gallery" alt="">
                        <div class="clearfix"></div>
                        <div class="col-xs-12 margin-top20">
                            <button type="button" class="btn btn-danger" data-dismiss="modal"><i class="fa fa-times"></i> Close</button>
                        </div>
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
    <script src="js/rti.js"></script>
    <script>
    </script>

</body>

</html>
