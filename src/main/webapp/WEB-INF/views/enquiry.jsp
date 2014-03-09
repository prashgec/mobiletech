<%@ include file="header.jsp"%>

<div class="clearfix pushUp">
	<br>
	<h1>&nbsp;&nbsp;&nbsp;Please fill the form for Enquiry</h1>
	<hr>
	<div class="clearfix">
		<br>
		<br>
		<p>
		<ul class="hoverList verticalList editText pushDown aLaUne">
			<li>
			<div class="w23 left tLeft">
			<span>
					<h2> </h2>
			
	<form name="myForm" action="" method="POST" onsubmit="return validateForm()" >
    <input type="hidden" name="action" value="submit"/> Your name:<br />
    <input id="name" name="name" type="text" value="" size="30"/> <br /> Your Contact No:<br />
    <input id="contact" name="contact" type="text" value="" size="30"/> <br /> Your email:<br />
    <input id="email" name="email" type="text" value="" size="30"/> <br /> Your message:<br />
    <textarea id="message" name="message" rows="7" cols="30"> </textarea> <br />
    <input type="submit" value="Submit"/>
   </form> </span>
						</div>
			</li>
			
			<li><a class="clearfix" href="http://www.mobiletech.co.in"> 
			<div class="w23 left tLeft">
			<span
					class="tBlack tLight tMedium tShadow  w35">
					<br/>
					<br/>
					<br/>
					
					</span>
						</div>
			</a></li>
		</ul>
	</div>
</div>

<%@ include file="footer.jsp"%>