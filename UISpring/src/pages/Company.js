import {
    Box,
    Card,
    Grid,
    TextField,
    Typography,
    InputAdornment,
    Button,
  } from "@mui/material";
  import axios from "axios";
  import React, { useEffect, useState } from "react";
  import SearchIcon from "@mui/icons-material/Search";
  import { Link } from "react-router-dom";

  
  const Company = () => {
    const [query, setQuery] = useState("");
    const [post, setPost] = useState();
  
    //
    useEffect(() => {
      const fetchPosts = async () => {
        const response = await axios.get(`http://localhost:1234/jobs/search?searchTerm=${query}`);
        setPost(response.data);
      };
      const fetchInitialPosts = async () => {
          const response = await axios.get('http://localhost:1234/jobs/alljobs');
          console.log(response);
          setPost(response.data);
      }
      if (query.length === 0) fetchInitialPosts();
      if (query.length > 2) fetchPosts();
    }, [query]);
  console.log(post);
    return (
      <Grid container spacing={2} sx={{ margin: "2%" }}>
        <Grid item xs={12} sx={12} md={12} lg={12}>
        <Button sx={{ margin: "1% 2%" }} variant="outlined">
              <Link to="/">Company</Link>
            </Button>
          <Box>
            <TextField
              InputProps={{
                startAdornment: (
                  <InputAdornment position="start">
                    <SearchIcon />
                  </InputAdornment>
                ),
              }}
              placeholder="Search..."
              sx={{ width: "75%", padding: "2% auto" }}
              fullWidth
              onChange={(e) => setQuery(e.target.value)}
            />
          </Box>
        </Grid>
        {post &&
          post.map((p) => {
            return (
              <Grid key={p.id} item xs={12} md={6} lg={4}>
                <Card sx={{ padding: "3%", overflow: "hidden", width: "84%" }}>
                  <Typography
                    variant="h5"
                    sx={{ fontSize: "2rem", fontWeight: "600" }}
                  >
               {p.jobtitle}
                  </Typography>
                  <Typography sx={{ color: "#585858", marginTop:"2%" }} variant="body" >
                    Description: {p.jobdescription}
                  </Typography>
                  <br />
                  <br />
                  <Typography variant="h6">
                    Years of Experience: {p.experience} years
                  </Typography>
                  <Typography variant="h6">
                    Minimum Salary: {p.minSalary} years
                  </Typography>
                  <Typography variant="h6">
                    Maximum Salary: {p.maxSalary} years
                  </Typography>
                  <Typography variant="h6">
                    Location: {p.location} years
                  </Typography>
  
                  <Typography gutterBottom  variant="body">Skills : </Typography>
                  {p.skills.map((s, i) => {
                    return (
                      <Typography variant="body" gutterBottom key={i}>
                        {s} .
                        {` `}
                      </Typography>
                    );
                  })}
    
                </Card>
              </Grid>
            );
          })}
      </Grid>
    );
  };
  
  export default Company;
  