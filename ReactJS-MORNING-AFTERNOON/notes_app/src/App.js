import React, { Component } from 'react';
import uuid from 'react-uuid'
import './App.css';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

/*
  This app has been developed by Ashish Samanta as part of Accolite University Assignments.
*/

class App extends Component{
  constructor(props){
    super(props)

    this.state = {
      newItem:'',
      notes:['One note already added for test purposes'],
      btnStateAdd: true,
      selectedItem:''
    }
    this.title = "Todo List"
  }

  handleAddItem = (event) => {
    this.setState({
      newItem: event.target.value,
    })
  }

  notify = (notifString) => toast(notifString);

  addItemBtnClick = (event) => {
    this.notify()
    if(this.state.btnStateAdd === true){
      if(this.state.newItem.trim() === ''){
        this.notify("Empty Notes cannot be added!")
        this.setState({
          newItem: ''
        })
        return
      }
      this.setState({
        notes: this.state.notes.concat([this.state.newItem]),
        newItem: ''
      })
      this.notify("Note Added!")
    }
    else{
      let newNoteList = this.state.notes
      newNoteList[this.state.selectedItem] = this.state.newItem
      this.setState({
        notes: newNoteList,
        btnStateAdd: !this.state.btnStateAdd,
        newItem: ''
      })
      this.notify("Note Edited!")
    }

  }

  clearBtnClicked = () => {
    this.setState({
      notes: []
    })
    this.notify("All Notes Deleted!")
  }

  handleEdit = (event) => {
    if(this.state.btnStateAdd === true){
      this.setState({
        selectedItem: event.target.id,
        btnStateAdd: !this.state.btnStateAdd,
        newItem: this.state.notes[event.target.id]
      })
    }
    else{
      this.notify("Please finish edit operation first!")
    }
  }

  handleDelete = (event) => {
    if(this.state.btnStateAdd === true){
      let newNoteList = this.state.notes
      newNoteList.splice(event.target.id,1)
      this.setState({
        notes: newNoteList
      })
      this.notify("Note Deleted!")
    }
    else{
      this.notify("Please finish edit operation first!")
    }
  }

  render(){

    let countValue = -1;
    const notesList = this.state.notes.map((note) => {
      countValue += 1;
      return  <div key={uuid()} style={{width:"100%",height:"44px",borderStyle:"solid",borderWidth:"1px",display:"flex",borderColor:"lightgray",borderRadius:"5px"}}>
                  <div style={{width:"90%",height:"40px",backgroundColor:"white",marginTop:"1px",marginLeft:"1px",textAlign:"left"}} >
                    <label style={{marginTop:"8px",marginLeft:"5px"}}>{note}</label>
                  </div>
                  <div style={{width:"5%",height:"40px",marginTop:"1px",marginLeft:"0px",float:"left",backgroundColor:"white"}} >
                    <img  alt="Edit-Btn" src="editForest.png" style={{height:"100%",width:"100%",objectFit:"scale-down"}} id={countValue} onClick={this.handleEdit}/>
                  </div>
                  <div style={{width:"5%",height:"40px",marginTop:"1px",marginLeft:"0px",float:"left",backgroundColor:"white",marginRight:"1px"}} >
                    <img  alt="Del-Btn" src="dustbinRed.png" style={{height:"100%",width:"100%",objectFit:"scale-down"}} id={countValue} onClick={this.handleDelete}/>
                  </div>
            </div>
    });

    const clearBtn = () => {
      if(this.state.notes.length>0){
        return (<button style={{width:"100%",height:"40px",borderStyle:"solid",borderWidth:"1px",borderColor:"lightgray",backgroundColor:"red",marginTop:"50px",color:"white",borderRadius:"5px",fontSize:"18px"}} onClick={this.clearBtnClicked}  > Clear List</button>)
      }else{
        return (<div></div>)
      }
    }

    const todoTitle = () => {
      if(this.state.notes.length>0){
        return (<h2 style={{marginTop:"50px",marginBottom:"20px"}}>Todo List</h2>)
      }
      else{
        return <div></div>
      }
    }

    let btnRenderValue = this.state.btnStateAdd === true ? "Add Item" : "Edit Item"


    return (<div style={{width:"60%",margin:"auto",textAlign:"center",marginTop:"30px"}}>
      <ToastContainer
          position="bottom-center"
          autoClose={2500}
          hideProgressBar={false}
          newestOnTop
          closeOnClick
          rtl={false}
          pauseOnFocusLoss
          draggable
          pauseOnHover
      />
      <h2 style={{marginBottom:"20px"}} >Todo Input</h2>
      <div style={{width:"100%",height:"150px",borderStyle:"solid",borderWidth:"1px",borderColor:"lightgray",borderRadius:"2px"}}>
        <div style={{width:"100%",margin:"auto",height:"50%",backgroundColor:"white",display:"flex"}}>
          <div style={{width:"5%",height:"40px",marginLeft:"10px",marginTop:"30px",backgroundColor:"white"}}>
            <img  alt="save-btn" src="saveIconBetter.png" style={{height:"100%",width:"100%",objectFit:"scale-down",backgroundColor:"#007AFF",borderStyle:"solid",borderWidth:"1px",borderColor:"lightgray",borderRadius:"5px 0px 0px 5px",borderRightWidth:"0px"}} />
          </div>
          <div style={{height:"40px",marginTop:"30px",marginLeft:"0px",width:"95%",marginRight:"20px",backgroundColor:"yellow",float:"left"}}>
            <input type="text" style={{height:"100%",width:"100%",borderStyle:"solid",borderWidth:"1px",borderColor:"lightgray",borderLeftWidth:"0px",borderRadius:"0px 5px 5px 0px"}} onChange={this.handleAddItem} placeholder="Add a Todo Item" value={this.state.newItem}></input>
          </div>
        </div>
        <div style={{width:"100%",height:"50%",backgroundColor:"white",marginTop:"0px",display:"flex"}}>
          <button className={this.state.btnStateAdd === true ? 'background-blue' : 'background-green' } id="add_editBtn" style={{height:"40px",width:"100%",marginTop:"18px",marginLeft:"10px",marginRight:"20px",borderStyle:"solid",borderWidth:"1px",borderColor:"lightgray",color:"white",borderRadius:"5px",fontSize:"18px"}} onClick={this.addItemBtnClick} > {btnRenderValue}</button>
        </div>
      </div>
      {todoTitle()}
      <div>
        {notesList}
      </div>
      <div>
        {clearBtn()}
      </div>
    </div>);
  }
}

export default App;

