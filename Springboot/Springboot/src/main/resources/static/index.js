async function init() {

  const registration = await navigator.serviceWorker.register('/sw.js');
  await navigator.serviceWorker.ready;	
  firebase.initializeApp({
	    messagingSenderId: "632846283860"
  });
  const messaging = firebase.messaging();
  messaging.usePublicVapidKey('BN0MmskweDEtSPnVtofl-238f30fKiUVO0GFTKFzfrJi3x6JOg6HRMNCdp6hz4JD-Ybo-uUcadW5OJ57Cm_60U8');
  messaging.useServiceWorker(registration);	
  
  try {
    await messaging.requestPermission();
  } catch (e) {
    console.log('Unable to get permission', e);
    return;
  }

  navigator.serviceWorker.addEventListener('message', event => {
    if (event.data === 'newData') {
      showData();
    }
  });

  const currentToken = await messaging.getToken();
  fetch('/register', { method: 'post', body: currentToken });
  showData();

  messaging.onTokenRefresh(async () => {
    console.log('token refreshed');
    const newToken = await messaging.getToken();
    fetch('/register', { method: 'post', body: currentToken });
  });
  
}

async function showData() {
  const db = await getDb();
  const tx = db.transaction('jokes', 'readonly');
  const store = tx.objectStore('jokes');
  store.getAll().onsuccess = e => showJokes(e.target.result);
}

function showJokes(jokes) {
  const table = document.getElementById('outTable');

  jokes.sort((a, b) => parseInt(b.ts) - parseInt(a.ts));
  const html = [];
  jokes.forEach(j => {
    const date = new Date(parseInt(j.ts));
    html.push(`<div><div class="header">${date.toISOString()} ${j.id} (${j.seq})</div><div class="joke">${j.joke}</div></div>`);
  });
  table.innerHTML = html.join('');
}

async function getDb() {
  if (this.db) {
    return Promise.resolve(this.db);
  }
  return new Promise(resolve => {
    const openRequest = indexedDB.open("Chuck", 1);

    openRequest.onupgradeneeded = event => {
      const db = event.target.result;
      db.createObjectStore('jokes', { keyPath: 'id' });
    };

    openRequest.onsuccess = event => {
      this.db = event.target.result;
      resolve(this.db);
    }
  });
}

init();