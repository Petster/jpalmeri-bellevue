import { useState } from 'react'
import { NavLink } from 'react-router-dom'
import 'animate.css'
import Logo from '../img/logoBright.png'
const desktopNav = [
    {
        display: "Home",
        link: "/"
    },
    {
        display: "About",
        link: "/about"
    }
];

const Nav = ({ autoshow }) => {
    const [menu, setMenu] = useState(false);
    return (
        <div className="w-full">
            <nav className="lg:hidden text-center w-full md:w-auto mx-auto">
                <img alt="JTP Logo" className={`mx-auto pt-2 pb-2 cursor-pointer`} onClick={() => setMenu(!menu)} width={60} src={Logo} />
                <div className={`w-full z-50  ${autoshow ? "content-show" : menu ? "content-show changeHeight" : "content-hide changeHeightR"}`}>
                    <div className={`space-x-6 text-center w-full md:w-auto mx-auto p-3`}>
                        {desktopNav.map((da, index) =>
                            <NavLink
                                key={index}
                                to={da.link}
                                className={({ isActive }) =>
                                    isActive
                                        ? 'text-white border-b-white border-b-2'
                                        : 'text-white hover:border-b-white border-b-transparent border-b-2'}>
                                {da.display}
                            </NavLink>
                        )}
                    </div>
                </div>
            </nav>
            <nav className="hidden lg:block text-center w-full md:w-auto mx-auto">
                <div className="flex flex-row">
                    <div>
                        <NavLink to="/" ><img alt="JTP Logo" className={`mx-auto pt-2 pb-2`} width={50} src={Logo} /></NavLink>
                    </div>
                    <div className="flex-grow"></div>
                    <div className="self-end">
                        <div className="space-x-6 text-center w-full md:w-auto mx-auto p-3">
                            {desktopNav.map((da, index) =>
                                <NavLink
                                    key={index}
                                    to={da.link}
                                    className={({ isActive }) =>
                                        isActive
                                            ? 'text-white border-b-white border-b-2'
                                            : 'text-white hover:border-b-white border-b-transparent border-b-2'}>
                                    {da.display}
                                </NavLink>
                            )}
                        </div>
                    </div>
                </div>
            </nav>
        </div>
    )
}

export default Nav;