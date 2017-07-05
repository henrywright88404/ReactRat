import React from 'react';
import { Route, Router, IndexRoute } from 'react-router';

import App from './components/app';
import Dashboard from './components/dashboard.js';
import Login from './components/login'

export default (
  <div>
  <Router>
    <Route path ='/' component={App}>
    <IndexRoute component ={Dashboard} />
    <Route path = 'dashboard' component={Dashboard}/>
    <Route path = 'login' component={Login}/>
    </Route>
  </Router>
  </div>
);
