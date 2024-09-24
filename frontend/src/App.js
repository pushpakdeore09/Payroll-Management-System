import './App.css';
import SignInForm from './pages/auth/Login';
import RegisterForm from './pages/auth/Register';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

function App() {
  return (
   <>
      <BrowserRouter>
        <Routes>
          <Route path='/signin' element={<SignInForm/>}/>
          <Route path='/signup' element={<RegisterForm/>}/>
        </Routes>
      </BrowserRouter>
   </>
  );
}

export default App;
