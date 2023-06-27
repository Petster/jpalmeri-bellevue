import { Helmet } from 'react-helmet'
import Favicon from '../img/logoBright.png'
import Nav from '../components/Nav'

const Layout = ({ children, title, index }) => {
    return (
        <div className={'bg-black bg-opacity-40 backdrop-filter backdrop-blur-sm'}>
            <main className="min-h-screen w-full md:w-3/4 mx-auto flex flex-col">
                <Helmet>
                    <title>{title}</title>
                    <link rel="icon" href={Favicon} />
                    <meta property="og:type" content="website"/>
                    <meta property="og:title" content="Jason Palmeri's Portfolio" />
                    <meta property="og:description" content="Jason Palmeri's Portfolio"/>
                    <meta property="og:url" content="https://portfolio.petstergaming.com"/>
                    <meta property="og:image" content="https://media.discordapp.net/attachments/903828993629896719/903829362644770876/ogimage.jpg?width=733&height=595"/>
                    <meta name="description" content="Portfolio Website for Jason Palmeri, Web Developer, Video Editor"/>
                    <meta name="keywords" content="Petster, Petstergaming, PetsterGaming, Petster12, HTML, CSS, JavaScript, PHP, JQuery, Portfolio, Jason Palmeri, Jason, Palmeri, Guavus, Nashua Community College, Graduate, Associates Degree, Associtates, Web Development Application, Web Development, Website Developer, Web Developer, Fiverr, Work, Looking for Work, Front-End Developer, Back-End Developer, Front-End Web Developer, Back-End Web Developer, Gaming, Games, Gamer, LinkedIn, Linkedin, Junior Web Developer, Customer Success"/>
                </Helmet>
                <header className="flex justify-between content-center flex-row">
                    {index ? <Nav autoshow={true} /> : <Nav autoshow={false} />}
                </header>
                <section className="flex flex-grow">
                    {children}
                </section>
                <footer className="md:rounded-t-md rounded-none w-full space-x-6 text-center mx-auto p-2">
                    <p className="text-white">Jason Palmeri | &copy; {new Date().getFullYear()}</p>
                </footer>
            </main>
        </div>
    )
}

export default Layout