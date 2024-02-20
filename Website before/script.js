
// JavaScript to add animation class when element is in view
document.addEventListener('DOMContentLoaded', function() {
    const animatedText = document.querySelector('.animated-text');

    // Check if element is in view
    function isElementInViewport(el) {
        var rect = el.getBoundingClientRect();
        return (
            rect.top >= 0 &&
            rect.left >= 0 &&
            rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
            rect.right <= (window.innerWidth || document.documentElement.clientWidth)
        );
    }

    function handleScroll() {
        if (isElementInViewport(animatedText)) {
            animatedText.classList.add('animate');
            // Remove the event listener after animation has been triggered
            window.removeEventListener('scroll', handleScroll);
        }
    }

    window.addEventListener('scroll', handleScroll);
});


