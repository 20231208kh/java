import { useEffect, useState } from 'react';

function App() {
  let [list, setList] = useState([]);

    useEffect(() => {
        fetch('/api/board/list')
            .then((res) => res.json())
            .then(res=>res.list)
            .then(res=res.forEach(item=>{
              console.log(item);
            }))
    }, []);
  return (
    <div className="App">

    </div>
  );
}

export default App;
