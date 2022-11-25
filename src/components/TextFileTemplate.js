//import * as React from 'react';
import React, {useEffect, useState} from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Button, Container, Paper } from '@mui/material';

export default function BasicTextFields() {
    const[name,setName] = useState('')
    const[surname,setSurame] = useState('')
    const[email,setEmail] = useState('')
    const[notes,setNotes] = useState('')
    const[status,setStatus] = useState('')
    const[id,setId] = useState('')

    const[candidate,setCandidate] = useState([])

    const handleClick=(e)=>{
        e.preventDefault()
        const candidate = {name, surname, email, notes, status}
        console.log(candidate)
        fetch("http://localhost:5050/createCandidate/", {
            method : "POST",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(candidate)
        }).then(()=> {console.log("New candidate added")})
    }

    const updateClick=(e)=>{
        e.preventDefault()
        const candidate = {name, surname, email, notes, status}
        console.log(candidate)
        fetch("http://localhost:5050/updateCandidate/" + e.detail,{
            method : "PUT",
            headers : {"Content-Type" : "application/json"},
            body : JSON.stringify(candidate)
        }).then(()=> {console.log("Candidate Updated")})
    }

    const deleteClick=(e)=>{
        e.preventDefault()
        console.log(e.detail)
        fetch("http://localhost:5050/deleteCandidate/" + e.detail,{
            method : "DEL"
        }).then(()=> {console.log("Candidate Deleted")})
    }

    useEffect(()=>{
        fetch("http://localhost:5050/candidates/")
        .then(res => res.json())
        .then((result)=>{
            setCandidate(result)
        })
    },[])

  return (
    <Container>
    <Box
      component="form"
      sx={{'& > :not(style)': { m: 1, width: '25ch' },}}noValidate autoComplete="off">

      <TextField id="outlined-basic" label="Name" variant="outlined"
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Surname" variant="outlined"
      value={surname}
      onChange={(e)=>setSurame(e.target.value)}
      />
      <TextField id="outlined-basic" label="E-mail" variant="outlined"
      value={email}
      onChange={(e)=>setEmail(e.target.value)}
      />
      <TextField id="outlined-basic" label="Notes" variant="outlined"
      value={notes}
      onChange={(e)=>setNotes(e.target.value)}
      />
      <TextField id="outlined-basic" label="Status" variant="outlined"
      value={status}
      onChange={(e)=>setStatus(e.target.value)}
      />

    <Button variant="contained" onClick={handleClick}>Add Candidate</Button>
    </Box>

    <Paper>
        <h1>
            Candidates
        </h1>
        {candidate.map(cand=>(
            <Paper key={cand.id}>
                Id : {cand.id}
                Name : {cand.name}
                Surname : {cand.surname}
                Email : {cand.email}
                Notes : {cand.notes}
                Status : {cand.status}
            </Paper>
        ))}
    </Paper>

    <Box
      component="form"
      sx={{'& > :not(style)': { m: 1, width: '25ch' },}}noValidate autoComplete="off">
        
      <TextField id="outlined-basic" label="Id" variant="outlined"
      value={id}
      onChange={(e)=>setId(e.target.value)}
      />
      
      <TextField id="outlined-basic" label="Name" variant="outlined"
      value={name}
      onChange={(e)=>setName(e.target.value)}
      />
      <TextField id="outlined-basic" label="Surname" variant="outlined"
      value={surname}
      onChange={(e)=>setSurame(e.target.value)}
      />
      <TextField id="outlined-basic" label="E-mail" variant="outlined"
      value={email}
      onChange={(e)=>setEmail(e.target.value)}
      />
      <TextField id="outlined-basic" label="Notes" variant="outlined"
      value={notes}
      onChange={(e)=>setNotes(e.target.value)}
      />
      <TextField id="outlined-basic" label="Status" variant="outlined"
      value={status}
      onChange={(e)=>setStatus(e.target.value)}
      />

    <Button variant="contained" onClick={updateClick}>Submit ID for Update</Button>
    
    </Box>

    <Box
      component="form"
      sx={{'& > :not(style)': { m: 1, width: '25ch' },}}noValidate autoComplete="off">
        
      <TextField id="outlined-basic" label="Id" variant="outlined"
      value={id}
      onChange={(e)=>setId(e.target.value)}
      />
    <Button variant="contained" onClick={deleteClick}>Submit ID to Delete</Button>
    </Box>

    
    </Container>
  );
}
