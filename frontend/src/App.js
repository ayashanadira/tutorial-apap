import React from "react";
import List from "components/List";
import listMovies from "movies.json";
import './App.css';
import EmptyState from "components/EmptyState";
import ToggleSwitch from "components/Toggle";

export default class App extends React.Component{
  constructor(props){
    super(props)
    this.state = {
      favItems : [],
      show : true 
    };
    this.handleToggleSwitch = this.handleToggleSwitch.bind(this);
  }

  handleToggleSwitch = () => {
    const {show} = this.state;
    this.setState({show : !show});
   
  }

  handleItemClick = (item) => {
    const newItems = [...this.state.favItems];
    const newItem = { ...item };

    const targetInd = newItems.findIndex(it => it.id === newItem.id);
    if (targetInd < 0) newItems.push(newItem);

    this.setState({ favItems: newItems });
  };

  clearFavoriteItems = () => {
    this.setState({ favItems: [] });
  };

  render(){
    const { favItems } = this.state;
    return (
      <div className="container-fluid">
        <h1 className="text-center mt-3 mb-0">Favorites Movie App</h1>
        <p className="text-center text-secondary text-sm font-italic">
          (This is a <strong>class-based</strong> application)
        </p>
    
        <ToggleSwitch 
          isOn={!this.state.show}
          handleToggle={this.handleToggleSwitch}
        /> Show Favorites

          <div className="container pt-3">
          <div className="row">
          <div className="col-sm">  
              <List
                title="List Movies"
                items={listMovies}
                onItemClick={this.handleItemClick}
              />
            </div>

            {!this.state.show ?
            <div className="col-sm">
              {!this.state.favItems.length ? <EmptyState/> :
              <List
                title="My Favorites"
                items={favItems}
                onItemClick={this.handleItemClick}
                />}
              {favItems.length > 0 ? 
              <button className="btn btn-danger" onClick={this.clearFavoriteItems}>Clear My Favorites</button>
              : null } 
            </div>
            : null} 

          </div>
        </div>
      </div>
    );
  }
}