import { useState } from 'react';
import {BrowserRouter, Route, Link, Routes, useLocation, useNavigate} from 'react-router-dom'
import React from 'react';

function App() {
  let [list,setList] = useState([]);
  function add(music){
    setList([music, ...list]);
  }

  function remove(num){
    let tmpList = list.filter(item=>item.num !== num);
    setList(tmpList);
  }

  return(
  <BrowserRouter>
    <Nav />
    <Routes>
      <Route path="/" exact element={<List list={list} add={add} remove={remove}/>} />
      <Route path="/add" element={<Add />} />
    </Routes>
  </BrowserRouter>
  );
}

function Nav(){
  return(
    <ul className="menu-list">
      <li><Link to="/">음악 조회</Link></li>
      <li><Link to="/add">음악 추가</Link></li>
    </ul>
  );
}


function List({list, add, remove}){
  const location = useLocation();
  let music = location.state;
  if(music!=null){
    add(music);
    location.state = null;
  }



  return(
    <div>
      <h1>음악 리스트</h1>
      <table>
        <thead>
          <tr>
            <th>음악번호</th>
            <th>가수</th>
            <th>제목</th>
            <th>장르</th>
          </tr>
        </thead>
        <tbody>
          {
            list.map((item)=>{
              return(
                <tr key={item.num}>
                  <td>{item.num}</td>
                  <td>{item.title}</td>
                  <td>{item.artist}</td>
                  <td>{item.genre}</td>
                  <td>
                    <button onClick={()=>remove(item.num)}>삭제</button>
                  </td>
                </tr>
              )
            })
          } 
        </tbody>
      </table>
    </div>
  );
};


function Add(){
  const navigate = useNavigate();
  let [num,setNum] = React.useState(0);
  let [artist, setArtist] = React.useState("");
  let [genre, setGenre] = React.useState("");
  let [title, setTitle] = React.useState("");

  function addMusic(){
    navigate("/",{
      state : {
        num,
        artist,
        genre,
        title
      }
    })
    
  }
  return(
    <div>
      <h1>음악 추가</h1>
      <div>
        <label>음악 번호</label>
        <input type="number" onChange={(e)=>{setNum(e.target.value)}}/>
      </div>
      <div>
        <label>가수</label>
        <input type="text" onChange={(e)=>{setArtist(e.target.value)}}/>
      </div>
      <div>
        <label>제목</label>
        <input type="text" onChange={(e)=>{setTitle(e.target.value)}}/>
      </div>
      <div>
        <label>장르</label>
        <input type="text" onChange={(e)=>{setGenre(e.target.value)}}/>
      </div>
      <button onClick={addMusic}>추가</button>
    </div>
  );
};

export default App;