import {BrowserRouter, Route, Routes} from 'react-router-dom'
import Index from "./pages/Index.jsx";
import About from "./pages/About.jsx";

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path={'/'} element={<Index/>} />
        <Route path={'/about'} element={<About/>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App
