const navMap = {
    "Profile.html": "profile",
    "Career.html": "career",
    "Hobby.html": "hobby",
    "Connect.html": "connect",
};

function setActiveNav() {
    const fileName = window.location.pathname.split("/").pop() || "Profile.html";
    const activePage = navMap[fileName] || "profile";
    const links = document.querySelectorAll(".nav-link");

    links.forEach((link) => {
        const page = link.dataset.page;
        if (page === activePage) {
            link.setAttribute("aria-current", "page");
        } else {
            link.removeAttribute("aria-current");
        }
    });
}

function setCurrentYear() {
    const target = document.querySelector("[data-year]");
    if (target) {
        target.textContent = new Date().getFullYear().toString();
    }
}

window.addEventListener("DOMContentLoaded", () => {
    setActiveNav();
    setCurrentYear();
});
