import {ReactComponent as GithubLogo} from "assests/img/github-logo.svg";
import './styles.css'

function Navbar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content">
                    <h1>DSMovie</h1>
                    <a href="https://www.github.com/devsuperior">
                        <div className="dsmovie-contact-container">
                            <GithubLogo/>
                            <p className="dsmovie-contact-link">/devsuperior</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default Navbar;