import React from 'react';
import { Route, Router, IndexRoute } from 'react-router';
import App from './components/app';

export default (
  <div>
  <Router>
    <Route path ='/' component={App}>
    </Route>
  </Router>
  </div>
);
