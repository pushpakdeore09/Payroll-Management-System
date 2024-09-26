import './App.css';
import SignInForm from './pages/auth/Login';
import RegisterForm from './pages/auth/Register';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Homepage from './pages/home/Homepage';

function App() {
  return (
   <>
      <BrowserRouter>
        <Routes>
          <Route path='/signin' element={<SignInForm/>}/>
          <Route path='/signup' element={<RegisterForm/>}/>
          <Route path='/' element={<Homepage/>}/>
        </Routes>
      </BrowserRouter>
     
   </>
  );
}

export default App;
