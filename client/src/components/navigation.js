import React, { Component } from "react";
import { Link } from 'react-router';

export default class Navigation extends Component {
  render() {
    return (
      <div className="frame bit-1 navigation_container">

        <h3 className="bit-40">Journey to React</h3>
        <ul className="bit-60 nav-menu">
          <li><Link to="dashboard">Dashboard</Link></li>
          <li><Link to="login">Login</Link></li>
        </ul>
      </div>
    );
  }
}
