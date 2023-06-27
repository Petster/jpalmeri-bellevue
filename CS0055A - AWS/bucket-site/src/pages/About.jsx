import Layout from '../components/Layout'
import { NavLink } from 'react-router-dom'
import { LazyLoadImage } from 'react-lazy-load-image-component'
import 'react-lazy-load-image-component/src/effects/black-and-white.css';
import myFace from '../img/myface.jpg'
import deanWinter from '../img/2021_winter_dean_gpa.png'
import deanSpring from '../img/2022_spring_dean.png'

const pStyle = "text-left text-lg leading-loose";
const hStyle = "text-xl underline font-bold";
const liStyle = "text-lg list-disc leading-loose ml-6"

const today = new Date();
const birthday = new Date("October 30 " + today.getFullYear());
let age = today.getFullYear().toString().substring(2)

if(today <= birthday) {
    age -= 1;
}

const About = () => {
    return (
        <Layout title="Jason Palmeri | About Me">
            <section className="flex flex-grow items-center justify-center bg-port sm:p-2">
                <div className="flex">
                    <div className="t-bg p-3 rounded-none md:rounded-lg text-white">
                        <div className="flex flex-col space-y-4 md:float-right float-none text-center">
                            <LazyLoadImage placeholderSrc={myFace} effect="black-and-white" src={myFace} className="border border-black shadow-2xl rounded-full md:h-72 md:w-72 h-96 w-96 mx-auto md:mx-none" />
                            <div className='flex flex-row gap-4 mx-auto'>
                                <a title="Deans List 2021 Winter" href="https://www.credly.com/badges/dd9160b7-a2e8-4dad-94c3-4048b83e09eb/public_url" target="_blank">
                                    <span className="sr-only">Bellevue University Deans List 2021 Winter 4.0 GPA</span>
                                    <LazyLoadImage placeholderSrc={deanWinter} effect="black-and-white" src={deanWinter} className="border border-black shadow-2xl rounded-full h-48 w-48 md:h-36 md:w-36" />
                                </a>
                                <a title="Deans List 2022 Spring" href="https://www.credly.com/badges/205e5234-b0ac-44f8-8a70-31ddf4411ed2/public_url" target="_blank">
                                    <span className="sr-only">Bellevue University Deans List 2022 Spring 4.0 GPA</span>
                                    <LazyLoadImage placeholderSrc={deanSpring} effect="black-and-white" src={deanSpring} className="border border-black shadow-2xl rounded-full h-48 w-48 md:h-36 md:w-36" />
                                </a>
                            </div>
                        </div>
                        <p className={pStyle}>
                            <span className={hStyle}>Hey! My name is Jason Palmeri</span>, I'm {age} years old with an Associates Degree in Web Application Development. I am currently enrolled at Bellevue University for their Software Development Bachelors Program and expect to graduate mid 2023.</p>
                        <br/>
                        <h1 className={hStyle}>Early Life</h1>
                        <p className={pStyle}>When I was younger I was always fascinated with technology, I would spend most of my free time playing video games, watching youtube and twitch, and learning as much as I could about the things I loved. I loved to play around with the junk computers that my father had down in the basement, and with a little help from youtube I taught myself about computer building, and have had my own custom built computer ever since. Having always been interested in youtube and twitch, I eventually saw myself creating videos and live streaming, though I didn't have many viewers or subscribers I kept uploading and streaming, and learning to get better at using the tools available to me like Adobe Premiere Pro, Sony Vegas, and Adobe Photoshop.</p>
                        <br/>
                        <h1 className={hStyle}>Path to Programming</h1>
                        <p className={pStyle}>Creating things has always been something that was interesting to me, I always admired the things people built online, watching people build replica game items in real life, creating apps, and games. I always wanted to do these things, but never took the initiative. When sophomore year of High School rolled around I had the opportunity to take a new intro to web design and development class. It was my instructor Mark Illingworth who really got me interested in programming, the way he taught the class made it fun and exciting, and he always had something challenging for us to learn. After that class I was on a non-stop journey, I wanted to learn as much as I could. I continued my education at Nashua Community College where I learned new programming languages, and went more indepth into web development and design.</p>
                        <br/>
                        <h1 className={hStyle}>Today</h1>
                        <p className={pStyle}>Today I work at Pinpoint Global as a QA Engineer for their suite of LMS sites to provide medicare providers with online certification training. My duties have included:</p>
                        <ul>
                            <li className={liStyle}>Writing and Executing test cases</li>
                            <li className={liStyle}>Creating Automation testing software (via Selenium)</li>
                            <li className={liStyle}>Creating Internal tools to help the support team</li>
                        </ul>
                        <p className={pStyle}>Being at Pinpoint has been an amazing experience, and I continue to learn more every day.</p>
                    </div>
                </div>
            </section>
        </Layout>
    )
}
export default About;
