document.addEventListener("DOMContentLoaded", function() {
	const toggle = document.getElementById("togglePass");
	const password = document.getElementById("empPass");

	toggle.addEventListener("click", function() {
		if (password.type === "password") {
			password.type = "text";
			toggle.src = "img/目のフリーアイコン5.png"; 
		} else {
			password.type = "password";
			toggle.src = "img/まつ毛のアイコン.png";
		}
	});
});
