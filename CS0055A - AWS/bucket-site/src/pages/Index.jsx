import Layout from "../components/Layout.jsx";

const Index = () => {
    return (
        <Layout title="Jason Palmeri | CS55A" index>
            <div className="flex flex-grow content-center items-center justify-center">
                <div id="indexCard" className="text-center space-y-2 p-6 text-white rounded-xl">
                    <h1 className="text-5xl sm:text-6xl md:text-7xl lg:text-8xl text-white font-open-sans text-center">Jason Palmeri</h1>
                    <h2 className="text-base sm:text-md md:text-2xl text-white text-center font-open-sans">Student / Web Developer / Video Editor</h2>
                    <h1 className="text-3xl sm:text-4xl md:text-5xl lg:text-6xl text-white text-center font-open-sans">CS 55A</h1>
                    <div className="grid grid-cols-6 text-center pt-4 gap-6">
                    </div>
                </div>
            </div>
        </Layout>
    )
}

export default Index;
