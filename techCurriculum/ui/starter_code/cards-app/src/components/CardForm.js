import React from 'react';
import TextInput from './TextInput.js'

class CardForm extends React.Component {
  constructor(props) {
    super(props);
    this.state = {username: '', message: ''};
  }

  handleUsernameChange = (value) => {
    this.setState({username: value});
  }

  handleMessageChange = (value) => {
    this.setState({message: value});
  }

  handleSubmit = (event) => {

  }

  render() {
    return (
      <form className='card-form'>
        <h2>Add a Card</h2>
        <TextInput name='username' label='Username' value={this.state.username} onChange={this.handleUsernameChange}/>
        <TextInput name='message' label='Message' value={this.state.message} onChange={this.handleMessageChange}/>
        <button className='btn btn-primary' onClick={this.handleSubmit}>Submit</button>
      </form>
    );
  }
}

export default CardForm;
